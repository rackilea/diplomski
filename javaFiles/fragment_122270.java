public interface ApplicationStartedListener {

        void applicationStarted();

        void foreignApplicationStarted(String name);

        void messageArrived(Object obj);
    }

//

    import java.io.Serializable;

    public class ClassCheck implements Serializable {

        private static final long serialVersionUID = 1L;
        private String className = null;

        public ClassCheck() {
        }

        public ClassCheck(String className) {
            setClassName(className);
        }

        @Override
        public String toString() {
            return this.className;
        }

        public String getClassName() {
            return this.className;
        }

        public void setClassName(String className) {
            this.className = className;
        }
    }
//

    import java.awt.AWTException;
    import java.awt.BorderLayout;
    import java.awt.Frame;
    import java.awt.MouseInfo;
    import java.awt.Point;
    import java.awt.Robot;
    import java.awt.event.InputEvent;
    import java.io.File;
    import javax.swing.JFrame;
    import javax.swing.JTextField;
    import javax.swing.SwingUtilities;

    public class RunOnceFromFile {

        private SingleInstanceController sic = null;
        private JFrame frame;
        private Robot r;
        private JTextField tf;

        public RunOnceFromFile() {
            try {
                r = new Robot();
            } catch (AWTException ex) {
                ex.printStackTrace();
            }
            sic = new SingleInstanceController(new File(System.getProperty("java.io.tmpdir") + "Example.file"), "sic_example_application");
            if (sic.isOtherInstanceRunning()) {
                sic.sendMessageToRunningApplication("toFront");
                System.exit(0);
            } else {
                frame = new JFrame("TEST");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 300);
                tf = new JTextField("JTextFiled");
                frame.add(tf, BorderLayout.NORTH);
                frame.setExtendedState(Frame.ICONIFIED);
                frame.setExtendedState(Frame.NORMAL);
                frame.setExtendedState(frame.getExtendedState() | JFrame.ICONIFIED);
                frame.setExtendedState(frame.getExtendedState() & (~JFrame.ICONIFIED));
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                sic.registerApplication();
                sic.addApplicationStartedListener(new ApplicationStartedListener() {

                    public void applicationStarted() {
                        Runnable doRun = new Runnable() {

                            public void run() {
                                frame.toFront();
                            }
                        };
                        SwingUtilities.invokeLater(doRun);
                    }

                    public void foreignApplicationStarted(final String name) {
                        Runnable doRun = new Runnable() {

                            public void run() {
                                frame.toFront();
                            }
                        };
                        SwingUtilities.invokeLater(doRun);
                    }

                    public void messageArrived(final Object obj) {
                        Runnable doRun = new Runnable() {//activateWindow(frame);

                            public void run() {
                                frame.toFront();
                            }
                        };
                        SwingUtilities.invokeLater(doRun);
                    }

                    private void activateWindow(JFrame frame) {
                        frame.setExtendedState(Frame.ICONIFIED);
                        frame.setExtendedState(Frame.NORMAL);
                        frame.setAlwaysOnTop(true);
                        frame.setAlwaysOnTop(false);
                        Point location = MouseInfo.getPointerInfo().getLocation();
                        Point locationOnScreen = frame.getLocationOnScreen();
                        r.mouseMove(locationOnScreen.x + 100, locationOnScreen.y + 10);
                        r.mousePress(InputEvent.BUTTON1_MASK);
                        r.mouseRelease(InputEvent.BUTTON1_MASK);
                        r.mouseMove(location.x, location.y);
                    }
                });
            }
        }

        public static void main(String[] args) {
            RunOnceFromFile roff = new RunOnceFromFile();
        }
    }
//

    import java.io.BufferedReader;
    import java.io.BufferedWriter;
    import java.io.File;
    import java.io.FileReader;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.io.ObjectInputStream;
    import java.io.ObjectOutputStream;
    import java.net.ServerSocket;
    import java.net.Socket;
    import java.util.ArrayList;

    public class SingleInstanceController {

        private String appname = null;
        private Socket client = null;
        private File file = null;
        private ArrayList<ApplicationStartedListener> listener = null;
        private ObjectInputStream ois = null;
        private ObjectOutputStream oos = null;
        private boolean result = false;
        private ServerSocket server = null;

        public SingleInstanceController(String appname) {
            this(new File(System.getProperty("java.io.tmpdir") + "/923jhakE53Kk9235b43.6m7"), appname);
        }

        public SingleInstanceController(File file, String appname) {
            this.file = file;
            this.appname = appname;
            this.listener = new ArrayList<ApplicationStartedListener>();
        }

        public void addApplicationStartedListener(ApplicationStartedListener asl) {
            this.listener.add(asl);
        }

        public void removeApplicationStartedListener(ApplicationStartedListener asl) {
            this.listener.remove(asl);
        }

        public boolean isOtherInstanceRunning() {
            if (!this.file.exists()) {
                return false;
            }
            return sendMessageToRunningApplication(new ClassCheck(this.appname));
        }

        public boolean sendMessageToRunningApplication(final Object obj) {
            this.result = false;
            try {
                this.client = new Socket("localhost", getPortNumber());
                new Thread(new Runnable() {

                    public void run() {
                        try {
                            SingleInstanceController.this.oos = new ObjectOutputStream(SingleInstanceController.this.client.getOutputStream());
                            SingleInstanceController.this.ois = new ObjectInputStream(SingleInstanceController.this.client.getInputStream());
                            SingleInstanceController.this.oos.writeObject(obj);
                            SingleInstanceController.this.oos.flush();
                            SingleInstanceController.this.result = SingleInstanceController.this.ois.readBoolean();
                        } catch (IOException e) {
                            SingleInstanceController.this.result = false;
                        }
                    }
                }).start();
                for (int i = 0; i < 10; i++) {
                    if (this.result == true) {
                        break;
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                this.client.close();
                return this.result;
            } catch (IOException e) {
                return false;
            }
        }

        public boolean registerApplication() {
            try {
                if (!this.file.exists()) {
                    if (!this.file.getParentFile().mkdirs() && !this.file.getParentFile().exists()) {
                        return false;
                    }
                    if (!this.file.createNewFile()) {
                        return false;
                    }
                }
                BufferedWriter wuffy = new BufferedWriter(new FileWriter(this.file));
                int port = getFreeServerSocket();
                if (port != -1) {
                    startServer();
                }
                wuffy.write(String.valueOf(port));
                wuffy.close();
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        protected void messageArrived(Object obj) {
            for (ApplicationStartedListener asl : this.listener) {
                asl.messageArrived(obj);
            }
        }

        protected void applicationStartet() {
            for (ApplicationStartedListener asl : this.listener) {
                asl.applicationStarted();
            }
        }

        protected void foreignApplicationStarted(String name) {
            for (ApplicationStartedListener asl : this.listener) {
                asl.foreignApplicationStarted(name);
            }
        }

        private int getPortNumber() {
            try {
                BufferedReader buffy = new BufferedReader(new FileReader(this.file));
                int port = Integer.parseInt(buffy.readLine().trim());
                buffy.close();
                return port;
            } catch (Exception e) {
                return -1;
            }
        }

        private void startServer() {
            new Thread(new Runnable() {

                public void run() {
                    while (true) {
                        try {
                            SingleInstanceController.this.client = SingleInstanceController.this.server.accept();
                            if (SingleInstanceController.this.client.getInetAddress().isLoopbackAddress()) {
                                new Thread(new Runnable() {

                                    public void run() {
                                        try {
                                            SingleInstanceController.this.oos = new ObjectOutputStream(SingleInstanceController.this.client.getOutputStream());
                                            SingleInstanceController.this.ois = new ObjectInputStream(SingleInstanceController.this.client.getInputStream());
                                            Object obj = SingleInstanceController.this.ois.readObject();
                                            if (obj instanceof ClassCheck) {
                                                if (obj.toString().equals(SingleInstanceController.this.appname)) {
                                                    SingleInstanceController.this.oos.writeBoolean(true);
                                                    applicationStartet();
                                                } else {
                                                    SingleInstanceController.this.oos.writeBoolean(false);
                                                    foreignApplicationStarted(obj.toString());
                                                }
                                            } else {
                                                messageArrived(obj);
                                                SingleInstanceController.this.oos.writeBoolean(true);
                                            }
                                            SingleInstanceController.this.oos.flush();
                                            SingleInstanceController.this.client.close();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        } catch (ClassNotFoundException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }).start();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

        private int getFreeServerSocket() {
            for (int i = 2000; i < 10000; i++) {
                try {
                    this.server = new ServerSocket(i);
                    return i;
                } catch (IOException ignore) {
                }
            }
            return -1;
        }
    }
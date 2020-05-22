public class TestJavaFXLoader extends JApplet {

    public static void main(String[] args) {
        new TestJavaFXLoader();
    }

    public TestJavaFXLoader() throws HeadlessException {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Loader loader = new Loader();
                loader.addPropertyChangeListener(new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        if (evt.getPropertyName().equals("state") && evt.getNewValue().equals(SwingWorker.StateValue.DONE)) {
                            System.out.println("Load main app here :D");
                        }
                    }
                });
                loader.load();
            }
        });
    }

    public class Loader extends SwingWorker<Object, String> {

        private JWindow splash;
        private JLabel subMessage;

        public Loader() {
        }

        protected void loadSplashScreen() {
            try {
                splash = new JWindow();
                JLabel content = new JLabel(new ImageIcon(ImageIO.read(...))));
                content.setLayout(new GridBagLayout());
                splash.setContentPane(content);

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridwidth = GridBagConstraints.REMAINDER;

                subMessage = createLabel("");

                splash.add(createLabel("Loading, please wait"), gbc);
                splash.add(subMessage, gbc);
                splash.pack();
                splash.setLocationRelativeTo(null);
                splash.setVisible(true);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        protected JLabel createLabel(String msg) {
            JLabel message = new JLabel("Loading, please wait");
            message.setForeground(Color.CYAN);
            Font font = message.getFont();
            message.setFont(font.deriveFont(Font.BOLD, 24));
            return message;
        }

        public void load() {
            if (!EventQueue.isDispatchThread()) {
                try {
                    SwingUtilities.invokeAndWait(new Runnable() {
                        @Override
                        public void run() {
                            loadSplashScreen();
                        }
                    });
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
            } else {
                loadSplashScreen();
            }
            execute();
        }

        @Override
        protected void done() {
            splash.dispose();
        }

        @Override
        protected void process(List<String> chunks) {
            subMessage.setText(chunks.get(chunks.size() - 1));
        }

        @Override
        protected Object doInBackground() throws Exception {

            publish("Preparing to load application");
            try {
                Thread.sleep(2500);
            } catch (InterruptedException interruptedException) {
            }
            publish("Loading JavaFX...");

            runAndWait(new Runnable() {
                @Override
                public void run() {
                    new JFXPanel();
                }
            });

            try {
                Thread.sleep(2500);
            } catch (InterruptedException interruptedException) {
            }
            return null;
        }

        public void runAndWait(final Runnable run)
                throws InterruptedException, ExecutionException {
            if (Platform.isFxApplicationThread()) {
                try {
                    run.run();
                } catch (Exception e) {
                    throw new ExecutionException(e);
                }
            } else {
                final Lock lock = new ReentrantLock();
                final Condition condition = lock.newCondition();
                lock.lock();
                try {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            lock.lock();
                            try {
                                run.run();
                            } catch (Throwable e) {
                                e.printStackTrace();
                            } finally {
                                try {
                                    condition.signal();
                                } finally {
                                    lock.unlock();
                                }
                            }
                        }
                    });
                    condition.await();
//                    if (throwableWrapper.t != null) {
//                        throw new ExecutionException(throwableWrapper.t);
//                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
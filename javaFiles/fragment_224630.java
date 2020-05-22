import de.professional_webworkx.dashboard.internalframes.WeatherIFrame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

public class MainFrame extends JFrame {

    private JDesktopPane desktopPane;
    private WeatherIFrame weatherIFrame;

    /**
     * Menuitems
     */
    MenuItem openWeatherFrame;
    MenuItem exitApp;

    public MainFrame() {            
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Dashboad");
        this.setSize(1024, 768);
        this.getContentPane().add(initDesktopPane());
        this.setMenuBar(initMenu());
        this.setVisible(true);
    }

    private JDesktopPane initDesktopPane() {
        desktopPane = new JDesktopPane();
        return desktopPane;
    }

    private MenuBar initMenu() {
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        openWeatherFrame = new MenuItem("Show Weatherforcast");
        openWeatherFrame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(weatherIFrame == null) {
                    weatherIFrame = new WeatherIFrame();
                    weatherIFrame.addInternalFrameListener(new InternalFrameListener() {

                        @Override
                        public void internalFrameOpened(InternalFrameEvent e) {
                        }

                        @Override
                        public void internalFrameClosing(InternalFrameEvent e) {
                        }

                        @Override
                        public void internalFrameClosed(InternalFrameEvent e) {
                            weatherIFrame = null;
                        }

                        @Override
                        public void internalFrameIconified(InternalFrameEvent e) {
                        }

                        @Override
                        public void internalFrameDeiconified(InternalFrameEvent e) {
                        }

                        @Override
                        public void internalFrameActivated(InternalFrameEvent e) {
                        }

                        @Override
                        public void internalFrameDeactivated(InternalFrameEvent e) {
                        }
                    });
                    desktopPane.add(weatherIFrame);
                }

            }
        });            
        fileMenu.add(openWeatherFrame);
        menuBar.add(fileMenu);
        return menuBar;
    }
}
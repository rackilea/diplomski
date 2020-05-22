public class LoggerListener implements ActionListener, WindowListener {

    ...

    @Override
    public void actionPerformed(ActionEvent e) {
       logger.log("Action performed!");
    }

    ...

    @Override
    public void windowOpened(WindowEvent e) {
        logger.log("Window opened!");
    }

}
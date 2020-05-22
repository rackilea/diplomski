public class MainWindow extends JFrame implements WindowListener {
    // this is ok
}
public class MainWindow extends JFrame, WindowAdapter {
    // this is not allow
}
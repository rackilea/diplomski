public class Frame extends JFrame implements Runnable {
private volatile Status status = 1;
...
@Override
public void run() {
    switch (status) {
        case 1:
        ...
        case 2:
        ...
}

public void updateGUI(Status status) {
   setStatus(status);
   SwingUtilities.invokeLater(this);
}

private synchronized void setStatus(Status status) {
   this.status = status;
}
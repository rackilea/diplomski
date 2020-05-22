private int msgLength;

@Override
public void start() {
    msgLength = Integer.parseInt(getFirstOption());
    super.start();
}
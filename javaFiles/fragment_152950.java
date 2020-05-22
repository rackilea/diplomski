@Override
protected boolean tryReleaseShared(int ignored) {
    setState(1);
    return true;
}
...
public void open() {
   sync.releaseShared(1);
}
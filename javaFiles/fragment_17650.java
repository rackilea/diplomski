private List<Runnable> mouseMoveListeners = new ArrayList<>(0);

...

public Registration addMouseMoveListener(Runnable listener) {
    mouseMoveListeners.add(listener);
    return () -> mouseMoveListeners.remove(listener);
}
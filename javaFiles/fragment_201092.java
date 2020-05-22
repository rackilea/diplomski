public void tryTo(Runnable action) {
    try {
        action.run();
    } catch (Exception e) {
        // do something?
    }
}

tryTo(() -> myObject.putA(a));
tryTo(() -> myObject.putB(b));
tryTo(() -> myObject.putC(c));
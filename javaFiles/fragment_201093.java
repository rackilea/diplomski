public void tryAll(Runnable... actions) {
    for (Runnable action : actions) {
        try {
            action.run();
        } catch (Exception e) {
            // do something?
        }
    }
}

tryAll(() -> myObject.putA(a),
        () -> myObject.putB(b),
        () -> myObject.putC(c));
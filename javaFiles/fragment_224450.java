boolean b = containsOne();
if (b) {
    // Do something with success...
} else {
    // Do something with failure...
}

private boolean containsOne() {
    for (Obj1 obj1 : objects1) {
        for (Obj2 obj2 : objects2) {
            if (...) {
                return true;
            }
        }
    }

    return false;
}
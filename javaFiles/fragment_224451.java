try {
    int i = getOne();
    // Do something with success...
} catch (Exception e) {
    // Do something with failure...
}

private int getOne() throws Exception {
    for (Obj1 obj1 : objects1) {
        for (Obj2 obj2 : objects2) {
            if (...){
                return 1;
            }
        }
    }

    throw new Exception();
}
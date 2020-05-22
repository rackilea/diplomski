public void forAllMembers(Foo[][] fooArray, Command c) {
    for (int i = 0; i < fooArray.length; i++) {
        for (int j = 0; j < fooArray[i].length; j++) {
            c.execute(fooArray[i][j]);
        }
    }
}
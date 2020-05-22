// somewhere in your code
    if (checkForClass("package.DeletedClass")) {
        new Runnable() {
            @Override public void run() {
                DeleteClass c = new DeleteClass();
                c.test(c);
            }.run();
        }
    }
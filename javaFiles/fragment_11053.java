String[] foo = {"-t", "-c", "myconfigfile", "-o", "outputfile"};

Arrays.stream(foo).forEachOrdered(new Consumer<String>() {
    String arg;

    public void accept(String val) {
        if (arg == null) {
            arg = val;
        } else if (t.startsWith("-")) {
            System.out.println(arg);
            arg = val;
        } else {
            System.out.println(arg + " " + val);
            arg = null;
        }
    }
});
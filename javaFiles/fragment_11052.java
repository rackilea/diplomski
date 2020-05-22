String[] foo = {"-c", "myconfigfile", "-o", "outputfile"};

Arrays.stream(foo).forEachOrdered(new Consumer<String>() {
    String last;

    public void accept(String t) {
        if (last == null) {
            last = t;
        } else {
            System.out.println(last + " " + t);
            last = null;
        }
    }
});
BufferedReader reader = new BufferedReader(new FileReader("foo.txt"));
    String foo = "";
    String old = "";
    while((foo = reader.readLine()) != null) {
        if(foo.equals(old)) {
            System.out.println("Sleeping...");
            Thread.sleep(1000);
        } else {
            old = foo;
        }
    }
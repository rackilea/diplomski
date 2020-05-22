File netDir = new File("\\\\usstll0032\\share\\drc"); // network drive
    System.out.println(netDir.isDirectory()); // true

    File badDir = new File("\\\\us39-0cmq142\\temp"); // my computer
    System.out.println(badDir.isDirectory());  // false

    File goodDir = new File("\\\\us39-0cmq142\\c$\\temp"); // my computer
    System.out.println(goodDir.isDirectory()); // true
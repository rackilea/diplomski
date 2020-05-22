Scanner in = null;
    try {
        in = new Scanner(new FileInputStream(txtFile));
    } catch (FileNotFoundException ex) {
        // work up exception
    }
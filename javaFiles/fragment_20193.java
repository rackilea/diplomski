public static File createFile() {

    try {
        file = new File("numbers.txt");

        f = new Formatter(file);
        f.close();

    } catch (SecurityException se) {
        System.err.println("You dont have write access to this file");
        System.exit(1);
    } catch (Exception ex) {

        System.err.println("Error opening or creating file");
        System.exit(1);

    }

    return file;
}
public static void main(String[] args) {

    if (args.length <= 0) {
        System.out.println("No arguments specified");
        return;
    }

    String filename = args[0];

    if (filename.trim().length() <= 0) {
        System.out.println("Filename is empty");
        return;
    }

    File file = new File(filename);

    if (!file.exists()) {
        System.out.println("File doesn't exist");
        return
    }

    // Do what you want with the file here
}
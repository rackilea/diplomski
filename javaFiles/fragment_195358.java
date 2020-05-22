public static void main(String[] args) {

    if (args.length <= 0) {
        System.out.println("No arguments specified");
        return;
    }

    List<File> files = new ArrayList<>();

    for (String filename : args) {

        File file = new File(filename);

        if (!file.exists()) {
            System.out.println("File doesn't exist");
            continue;
        }

        files.add(file);
    }

    // Do what you want with your list of files here
}
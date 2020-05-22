public static void main(String[] args) {
    for (int i = 0; i < args.length; i++) {
        System.out.println("Got arg: " + args[i]);
        File file = new File(args[i]);
        System.out.println("Parameter file: " + file.getAbsolutePath());
        if (file.exists()) {
            System.out.println("File exists. Getting parameters.");
        } else {
            System.out.println("File is not valid.");
        }
    }
}
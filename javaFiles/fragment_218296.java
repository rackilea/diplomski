class Plagiarism {

    public static void main(String[] args) throws Exception {
        //you are not using 'myPlag' anywhere, you can safely remove it
//      Plagiarism myPlag = new Plagiarism();

        if (args.length == 0) {
            System.out.println("Error: No files input");
            System.exit(0);
        }

        String foo = null;
        for (int i = 0; i < 2; i++) {
            BufferedReader reader = new BufferedReader(new FileReader(args[i]));
            foo = simplify(reader);
            System.out.println(foo);
        }

        int blockSize = Integer.valueOf(args[2]);
        System.out.println(args[2]);

        List<String> list = new ArrayList<String>();
        for (int k = 0; k < foo.length() - blockSize; k++) {
            list.add(foo.toString().substring(k, k + blockSize));
        }
        System.out.println(list);

    }

    public static String simplify(BufferedReader input)
            throws IOException {

        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = input.readLine()) != null) {
            sb.append(line.replaceAll("[^a-zA-Z]", "").toLowerCase());
        }
        return sb.toString();
    }
}
public static void main(String[] args) throws Exception {
    try (Scanner in = new Scanner(new File("D:/Javasorter/List.txt"))) {
        in.useDelimiter("[?! .,;:\t\r\n\f\'\"]");

        String word, pathbuf1, pathbuf2;
        while (in.hasNext()) {
            word = in.next().trim().toLowerCase();
            if (!word.isEmpty()) {
                System.out.println(word);

                Thread.sleep(1000);

                pathbuf1 = "\\IMG_" + word + ".CR2";
                pathbuf2 = "\\IMG_" + word + ".CR2";
                System.out.println(pathbuf1);
                System.out.println(pathbuf2);
            }
        }
    }
}
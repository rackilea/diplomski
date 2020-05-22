public class ShowRandomImage {
    private static String RANDOM_IMG_URL = "https://commons.wikimedia.org/wiki/Special:Random/File";

    public static void main(String[] args) throws Exception {
        URL url = new URL(RANDOM_IMG_URL);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8))) {
            in.lines().flatMap(s -> {
                int i = s.indexOf("<img ");
                if (i >= 0) {
                    int j = s.indexOf("src=\"");
                    if (j > 0) {
                        int k = s.indexOf('"', j+5);
                        if (k > 0) {
                            return Stream.of(s.substring(j+5,k));
                        }
                    }
                }
                return null;
            }).findFirst().ifPresent(ShowRandomImage::handleImage);
        }
    }

    private static void handleImage(String url) {
        System.out.println(url);
        try {
            URL imgUrl = new URL(url);
            JFrame frame = new JFrame("Random Image");
            frame.add(new JLabel(new ImageIcon(imgUrl)));
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } catch(Exception ex) {
            System.err.println("Something went wrong fetching the image: "+ex);
        }
    }
}
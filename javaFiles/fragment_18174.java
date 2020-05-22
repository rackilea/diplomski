public static void main(String[] args) throws IOException {
        {
            URL url = getClass().getClassLoader().getResource("css/demo.css");
            URL url2 = getClass().getClassLoader().getResource("");
            System.out.println("url = " + url);
            System.out.println("url_2 = " + url2);

        }
    }
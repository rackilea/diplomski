public static void main (String[] args) {
    Scanner scan = new Scanner(System.in);
    Scanner web = null;

    while (true) {
        try {
            String input = scan.nextLine();
            URL url = new URL(input);
            web = new Scanner(url.openStream());

            break;

        } catch (MalformedURLException e) {
            System.out.println("error occurred: " + e);

        } catch (IOException e) {
            System.out.println("error occurred: " + e);
        }
    }

    if (web != null ) {
        // do something with 'web'
    }
}
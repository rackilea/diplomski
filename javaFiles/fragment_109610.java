private void readResource(String path) {
        InputStream in = getClass().getClassLoader().getResourceAsStream(path); 
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        try (Scanner scanner = new Scanner(reader)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("LINE: " + line);
            }

            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
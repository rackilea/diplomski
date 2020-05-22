public static void main(String arg[]) {

    try (Scanner sc = new Scanner(new File("Resources/Map/spawn.txt"))) {
        // Checking if sc has another token in the file
        while(sc.hasNext()) {
            // Print line
            System.out.println(sc.next());
        }

    } catch (Exception ex) {
        // Use a Logger to log exceptions in real projects
        ex.printStackTrace();
    }
}
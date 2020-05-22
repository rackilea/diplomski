public class SearchClasses {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {


//      InputStream is = SearchClasses.class.getClassLoader().getResourceAsStream("resources.SearchClasses.class");
        InputStream is = new FileInputStream(new File("build/classes/resources/SearchClasses.class"));

        boolean found = false;
        Scanner scanner = new Scanner(is);
        while (scanner.hasNext()) {
            if (scanner.nextLine().contains("println")) {
                System.out.print("println found");
                found = true;
                break;
            }
        }

        if (!found) {
                System.out.print("println NOT found");          
        }

    }

    public static void testMethod() {
        System.out.println("testing");
    }

}
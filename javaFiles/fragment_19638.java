public void modifyExam(String [] names) {
    String name;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please enter the name of the student whose grade you would like to modify: ");
    name = scanner.nextLine();
    boolean nameMatch = false;
    for (int i=0; i<names.length; i++) {
        if( names[i].equals(name) ) {
            // do your logic here ...
        }
    }
}
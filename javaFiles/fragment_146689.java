public static void main(String[] args) {
    Scanner scanner = new Scanner( System.in );
    System.out.println("Insert Names:");
    List<String> names = getNames( scanner );
    System.out.println("Insert Marks:");
    List<Integer> marks = getMarks( scanner );
    for (int i = 0; i < names.size(); i++) {
        String name = names.get(i);
        int mark = marks.get(i);
        System.out.println( name + " - " + mark);
    }
    scanner.close();
}

private static List<String> getNames(Scanner scanner) {
    List<String> names= new ArrayList<>();
    for ( int i = 0 ; i < 3; i++){
        names.add(scanner.nextLine());
    }
    return names;
}

private static List<Integer> getMarks( Scanner scanner) {
    List<Integer> names= new ArrayList<>();
    for ( int i = 0 ; i < 3; i++){
        names.add(scanner.nextInt());
    }
    return names;
}
public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(new File("file.txt"));
    List<String> lines = new ArrayList<String>();
    while (sc.hasNextLine()){
        lines.add(sc.nextLine());
    }


    String[] arr = lines.toArray(new String[0]);
    String text = Arrays.toString(arr);
    String test = text.replaceAll("\\p{P}","");

    List<String> list = Arrays.asList(test.split(" ")); 
    SortedSet<String> uniq = new TreeSet<String>(list);


    for (String w : uniq){
        System.out.printf("%n%d     %s",Collections.frequency(list, w), w);

    }
}
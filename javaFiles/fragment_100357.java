public static void main(String[] args){
    Scanner file = new Scanner(new File("file path here"));

    ArrayList<String> strings = new ArrayList<String>();
    ArrayList<Integer> ints = new ArrayList<Integer>();
    ArrayList<Double> doubles = new ArrayList<Double>();

    while(file.hasNextLine()){
        strings.add(file.nextLine());
        ints.add(Integer.parseInt(file.nextLine()));
        doubles.add(Double.parseDouble(file.nextLine()));
        if(file.hasNextLine())
            file.nextLine();
    }
    file.close();
}
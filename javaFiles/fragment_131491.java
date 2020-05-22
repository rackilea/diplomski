ArrayList<Integer> row;
ArrayList<ArrayList<Integer>> columns = new ArrayList<ArrayList<Integer>>(); 
try {
    Scanner s = new Scanner(new File("1.txt"));
    while (s.hasNextLine()) {
        String[] temp = s.nextLine().split(" ");
        row = new ArrayList<Integer>();
        for(String i : temp) ints.add(Integer.parseInt(i));
        columns.add(row);
    }
}
catch (FileNotFoundException e) {
    e.printStackTrace();
}
static ArrayList<Integer> al = new ArrayList<Integer>();

public static void main(String[] args) {

    try {
        File file = new File("C:\\users\\sony\\Desktop\\456.txt");
        BufferedReader in = new BufferedReader(new FileReader(file));
        String s; 
        while ((s = in.readLine()) != null) {
            findInteger(s);
        }
        in.close();
    } catch (IOException e) {
        System.out.println("File Read Error: " + e.getMessage());
    }
    System.out.println("Integers: " + al);
}

private static void findInteger(String s){
    String [] parts = s.split(" ");

    for (int i = 0; i < parts.length; i++) {
        try{
            int j = Integer.parseInt(parts[i]);
            al.add(j);
        } catch (Exception e){}
    }
}
public static void main(String[] args) throws FileNotFoundException {
    BufferedReader in = new BufferedReader(new FileReader("src\\workshop7\\customers.txt"));
    String str;
    String names[];
    List<String> firstName = new ArrayList();
    List<String> lastName = new ArrayList();
    try {
        while ((str = in.readLine()) != null) {
            names = str.split("\\s");
            int count = 0;
            do{
                firstName.add(names[count]);
                lastName.add(names[count+1]);
                count = count + 2;
            }while(count < names.length);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    // do whatever with firstName list here
    System.out.println(firstName);
    // do whatever with LastName list here
    System.out.println(lastName);
}
public static void main(String[] args) {
    String strings = "one*10*two*11*three*12";
    String[] spl = strings.split("\\*");//split with *
    ArrayList<Integer> arrli = new ArrayList<>();
    List<String> al = new ArrayList<>();
    for (String s : spl) {//loop throw your resutl
        if (s.matches("\\d+")) {//check if your input is int or not
            arrli.add(Integer.parseInt(s));//if int add it to list of ints
        } else {
            al.add(s);//else add it to list of Strings
        }
    }
    System.out.println(al);//output [10, 11, 12]
    System.out.println(arrli);//output [one, two, three]

}
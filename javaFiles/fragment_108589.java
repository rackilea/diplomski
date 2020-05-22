public static void main (String args[]) {
    List<Integer> intList = new ArrayList();
    Scanner cin = new Scanner(System.in);
    System.out.println("Enter the sequence");//9103ndhai*25ma@#$
    String myString = "";
        String tempInt = cin.next();
        for(int i = 0; i< tempInt.length(); i++){
            String s = ""+tempInt.charAt(i);
        if(s.matches("[0-9]"))
            intList.add(Integer.parseInt(""+tempInt.charAt(i)));
        }


    Collections.sort (intList);
    for (int i=0; i<intList.size(); i++){
        System.out.print(intList.get(i));
    }
}
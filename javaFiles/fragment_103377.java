public static void main(String args[]) {
    String x = "Shojibur rahman";
    String[] myName = x.split(" ");
    for (int i = 0; i < myName.length; i++) {
        String s = myName[i];
        System.out.println(s.charAt(0));
    }
}
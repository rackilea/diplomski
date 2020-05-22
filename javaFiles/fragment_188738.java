class MainClass {
      public static void main(String[] args) {
        String regex="^[^\\d]*\\d+[^\\d]*$";
        System.out.println("1".matches(regex));  // true
        System.out.println("XX-1234".matches(regex)); // true
        System.out.println("XX-1234-YY".matches(regex)); // true
        System.out.println("do-not-match-no-integers".matches(regex)); // false
        System.out.println("do-not-match-1234-567".matches(regex)); // false
        System.out.println("do-not-match-123-456".matches(regex)); // false
      }         
}
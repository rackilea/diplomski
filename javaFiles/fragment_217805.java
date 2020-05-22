public static void main(String[] args) {

    String s = "/getCPage.asp?m=total&sub=$1$dga74$$/getEpage.asp?m=tatal&sub=0";

    Scanner scanner = new Scanner(s);
    scanner.useDelimiter("\\$\\$");

    System.out.println(scanner.next());
    System.out.println(scanner.next());
}
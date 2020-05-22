Scanner sc = new Scanner (System.in);
String[] lines = {"      *", "     **", "    ***", "   ****", "  *****"};
int input = Integer.parseInt(sc.nextLine());
for (int i=0; i < lines.length; ++i) {
    for (int j=0; j < input; ++j) {
        System.out.print(lines[i]);
        System.out.print(" ");
    }
    System.out.println();
}
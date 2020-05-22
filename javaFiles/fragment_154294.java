Scanner in = new Scanner(System.in);
int counter = 0;
int t = in.nextInt();
for (char ch : String.valueOf(t).toCharArray()) {
    if (ch != '0' && t % Character.digit(ch, 10) == 0) {
        counter++;
    }
}
System.out.println("count = " + counter);
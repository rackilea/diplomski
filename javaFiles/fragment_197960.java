int sum = 0;

Scanner sc = new Scanner(System.in);
System.out.println("Enter a 5 digit decimal number:");

char[] s = sc.next().toCharArray();

for (int i = 0; i < s.length; i++) {
    try {
        sum += Integer.parseInt(s[i] + "");
    } catch (Exception e) {
    }
}

System.out.println("Sum of digits = " + sum);
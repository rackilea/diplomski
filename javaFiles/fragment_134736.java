Scanner sc = new Scanner(System.in);
int[] f = new int[26];
System.out.println("Enter a string.");
String orig = sc.nextLine();
String k = orig.trim().toUpperCase();
System.out.println("Checking string = " + orig);
for (char ch : k.toCharArray()) {
    f[ch - 'A']++;
}
System.out.println("Char\tFreq");
for (int i = 0; i < f.length; i++) {
    if (f[i] != 0) {
        System.out.println((char) ('A' + i) + "\t" + f[i]);
    }
}
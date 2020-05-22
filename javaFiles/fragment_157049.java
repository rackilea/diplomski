Scanner sc = new Scanner(System.in);
System.out.print("Enter a student record: ");
String str = sc.nextLine();
StringTokenizer st = new StringTokenizer(str);

while (st.hasMoreTokens()) {
    String token = st.nextToken();
    // try to parse the token as an integer with try-catch Integer.parseInt()
    try {
        int num = Integer.parseInt(token);
        gpa += num;
        counter++;
    } catch (NumberFormatException e) {
        // if it fails, assume it's the name of the student
        studentName = token;
    }
}

// We only read a single line and we're not asking how much more there is.
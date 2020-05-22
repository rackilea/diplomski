public static void main(String[] args) {
    System.out.print("Enter a string: ");
    String s = sc.nextLine();
    String originalString = s;

    char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (contains(c, vowels)) {
            String front = s.substring(0, i);
            String back = s.substring(i + 1);
            s = front + "" + back;
        }
    }

    System.out.println(originalString);
    System.out.println(s);
}

private static boolean contains(char c, char[] arr) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == c) {
            return true;
        }
    }
    return false;
}
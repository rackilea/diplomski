Scanner input = new Scanner(System.in);
String str = input.nextLine();
StringBuilder sb = new StringBuilder(str);

for (int i = sb.length() - 2; i >= 0; i--) {
    for (int j = i + 1; j < sb.length(); j++) {
        if (sb.charAt(i) == sb.charAt(j)) {
            sb.deleteCharAt(j);
            sb.deleteCharAt(i);
            break;
        }
    }
}

System.out.println(sb);
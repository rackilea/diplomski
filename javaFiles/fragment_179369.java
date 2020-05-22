String input = args[0];
int sum = 0;
for (int i = 0; i < input.length(); i++) {
    char c = input.charAt(i);
    if (c != '0' && c != '1') {
        System.out.println("wrong string");
        break;
    }
    sum <<= 1;
    if (c == '1')
        sum |= 1;
}
System.out.println(sum);
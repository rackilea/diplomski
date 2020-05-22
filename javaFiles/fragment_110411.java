String input = "11010011011";
BitSet bs = new BitSet(input.length());
int i = 0;
for (char c : input.toCharArray()) {
    if (c == '1') bs.set(i);
    i++;
}
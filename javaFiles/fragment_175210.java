int i = 55;
char[] zerosOnes = Integer.toBinaryString(i).toCharArray();
String result = "";
for (char c : zerosOnes) {
    if (c == '1') {
        result += "one ";
    } else {
        result += "zero ";
    }
}
System.out.println(result);
=>one one two one one one
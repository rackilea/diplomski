public static void main(String[] args) throws ParseException {
int y = 777;// if y is 777 i am getting blank
int sum = 0;
String s;
char[] ch;
do {
    sum = 0;
    s = String.valueOf(y);
    ch = s.toCharArray();
    if (ch.length > 1) {
        for (int i = 0; i < ch.length; i++) {
            sum += Character.getNumericValue(ch[i]);
        }
    } else {
        System.out.println(ch[0]);
        break;
    }
    y = sum;
} while (ch.length > 1);
}
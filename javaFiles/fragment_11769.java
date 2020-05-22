public class prg11 {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a word.");
    String word = sc.next();
    sc.close();
    word = word.toUpperCase();
    int length = word.length();
    char ch[] = new char[length+1];
    for (int i = 0; i<length; i++) {
        ch[i] = word.charAt(i);
        if("AEIOU".indexOf(ch[i]) > -1) {
            ch[i]+=1;
        }
    }
    String str = new String(ch);
    System.out.println(str);
}
}
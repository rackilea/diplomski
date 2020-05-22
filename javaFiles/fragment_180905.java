public class Main {

public static void solution(String s) {
    char[] c = s.toCharArray();
            int j = 0, i = 0, counter = 0;
    for (i = 0; i < c.length; i++) {
        for (j = i; j < c.length; j++) {

            if (c[i] == c[j]) {
                counter++;

            }
        }
        System.out.println("The letter " + c[i] + " appears " + counter + " times");
        counter = 0;
    }
}

public static void main(String args[]) {
    String s = "abaababcdelkm";
    solution(s);
}
}
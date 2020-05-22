public class Main {
public static void main(String[] args) {
    loop:
    for (int i=0; i<10; i++) {
        switch (i) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 9:
            continue loop;
        }

        System.out.println(i);
    }
}
}
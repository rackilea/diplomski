public class practice {

int squares = 81;
public static void main(String[] args) {
    new practice().go();
}

void go() {
    incr(++squares);
    System.out.println(squares);
}

void incr(int squares) {
    squares += 10; 
    System.out.println(squares);
}
}
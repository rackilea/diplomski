public class Practice15 {

public static void main(String[] args) {


    Deque<Integer> dd=new ArrayDeque<Integer>();

    dd.offerFirst(123);

    dd.offerFirst(258);

    dd.offerFirst(125);

    System.out.println(dd);

    Queue<Integer> q1=Collections.asLifoQueue(dd);

    System.out.println(q1);

}
public static void main(String[] args) {

    List l = new Cons(3, new Cons(2,new Cons(1, new
            Cons(4, new Cons(1, new Nil())))));

    assert l.count() == 3;

    l = new Cons(5, new Nil());
    assert l.count() == 0;

    l = new Cons(5, new Cons(5, new Cons(0, new Nil())));
    assert l.count() == 1;

    l = new Cons(5, new Cons(0, new Cons(5, new Cons(3, new Nil()))));
    assert l.count() == 2;

    System.out.println("All tests completed successfully!");
}
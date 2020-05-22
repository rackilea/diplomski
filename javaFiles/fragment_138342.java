public class test {

static class Foo {

}

static class Moo extends Foo {

}

/**
 * @param args
 */
public static void main(String[] args) {

    List<Moo> list = new ArrayList<Moo>();
    for(int i=0; i<10; i++){
        list.add(new Moo());
    }

    List<Foo> listFoo = (List<Foo>) list;

}
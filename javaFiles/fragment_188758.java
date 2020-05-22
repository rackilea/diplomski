public static void main(String... args) {

    Element<String> element1 = new Element<String>(new String("First tuple element"));
    Element<String> element2 = new Element<String>(new String("Second tuple element"));

    Tuple<Element<String>> tuple = new Tuple<Element<String>>(element1, element2);

    // First tuple element
    System.out.println(tuple.getElement1().raw());

    // Second tuple element
    System.out.println(tuple.getElement2().raw());
}
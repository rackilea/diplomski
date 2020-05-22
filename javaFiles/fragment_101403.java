Foo foo = (Foo) session.get(Foo.class, 1L);
foo.setColor("red");
List<Foo> redFoos = 
    session.createQuery("select foo from Foo foo where foo.color = 'red'");
if (redFoos.isEmpty()) {
    System.out.println("WTF?");
}
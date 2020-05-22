@RequestMethod("/foo")
public void foo(@ModelAttribute("A") A a) {
    foobar(a, null);
}

@RequestMethod("/bar")
public void bar(@ModelAttribute("B") B b) {
    foobar(null, b);
}
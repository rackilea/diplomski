public void doSomething(Dims d) {
    System.out.println("The area is " + d.area());
}

// ...using it somewhere:

doSomething(new Triangle(4.0, 6.0));
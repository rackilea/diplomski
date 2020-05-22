public static void main(String[] args) throws Throwable {
    final JavaClass outerClass = Repository.lookupClass(ServiceOrder.class.getName());
    StringRepresentation s = new StringRepresentation(outerClass);
    System.out.println(s);
    BCELifier fier = new BCELifier(outerClass, System.out);
    fier.start();

    final JavaClass outer2Class = Repository.lookupClass(net.madz.lifecycle.solutionOne.ServiceOrder.class.getName());
    BCELifier fier2 = new BCELifier(outer2Class, System.out);
    fier2.start();
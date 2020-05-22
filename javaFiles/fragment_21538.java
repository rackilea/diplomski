MyInterface obj = theList.get(0);
if (obj instanceof MyClassOne) {
    System.out.println("It's MyClassOne");
} else if (obj instanceof MyClassTwo) {
    System.out.println("It's MyClassTwo");
}
interface Shape {
    int getArea();
    default void printArea(){
        System.out.println(this.getArea());
    }
}
public static void main(final String[] args){
    for(final Shape shape : Shape.values()){
        System.out.printf("Shape: %s, area: %1.2f\n", shape,
            shape.getArea());
    }
}
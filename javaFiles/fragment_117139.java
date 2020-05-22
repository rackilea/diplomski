public void InputRadius() throws IllegalRadiusException {
    System.out.print("Radius: ");
    double entered_radius = input.nextDouble();
    if (entered_radius >= 0) {
        this.radius = entered_radius;
        this.area = area;
    } else {
        throw new IllegalRadiusException("Radius Cannot be Negative");
    }

}
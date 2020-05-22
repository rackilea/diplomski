public constructor_name(String x, String y) {
    this.x = x;
    this.y = y;
    this.z = x + y; // or this.z = this.x + this.y;
    System.out.println("Sum is :::"+ this.z);
}
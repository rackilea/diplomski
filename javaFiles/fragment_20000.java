public void setHeight(double height) {
    System.out.println("got here ");
    if (height < 0) {
        this.height = 0.00;
    } else {
        this.height = height;   // set a new value for "this.height" if you didn't zero it out above
    }
}
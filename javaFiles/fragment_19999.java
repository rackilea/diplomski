public void setHeight(double height) {
    System.out.println("got here ");
    if (height < 0) {        // use "height" instead of "this.height"
        this.height = 0.00;
    }
}
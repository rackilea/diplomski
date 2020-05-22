public bool function() {
    if (this.number < this.max) {
        this.number = (short)(this.number + this.multiplicator);
        System.out.println("Number: " + this.number);
    } else {
        System.out.println("Ending of Number");
    }

    return (this.number < this.max);
}
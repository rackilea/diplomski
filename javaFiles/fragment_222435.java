public double dist(3DObj arg) {
    double dist = Math.sqrt(Math.pow((this.a - arg.a), 2)
                     + Math.pow((this.b - arg.b), 2) 
                     + Math.pow((this.c - arg.c), 2));
    return dist;
}
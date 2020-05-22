double findaroot(double x1, double x2){ //finds the root between two values
    double gap = Math.abs(x1 - x2); //find the initial interval
    if (gap > INTERVAL) { //check for precision           
        gap = gap / 2; //halve the interval
        double x3 = x1 + gap;
        if (f(x3) == 0) { //check for symmetry
            return x3;
        } else if (Math.signum(f(x1)) == Math.signum(f(x3))){
            x1 = x3; //redefine the interval
        } else {
            x2 = x3; //redefine the interval
        }
        return findaroot(x1, x2);
    }
    else
         return (x1 + x2) / 2; //return the mean
}
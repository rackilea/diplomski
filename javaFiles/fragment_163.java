public double inputParser(String s) {
    try {
        return Double.parseDouble(s);
    } catch (NumberFormatException e) {
        return -1;
    }
}
//and used instead of straight `Double.parseDouble`:
aP = inputParser(a);
bP = inputParser(b);
//which simplifies the `if` even more to:
if(hP != -1 && rP != -1) { //cylinder
    System.out.println(this.surfaceArea(hP, rP));
}
@Override
public String toString() {
    String output = "";

    for (int i = 1; i <= mHeight; i++) {
        for (int j = 1; j <= mTbase - i; j++) {
            output += "* ";
        }
        output += "\n";
    }
    output += "The area of this triangle is " + calculatedArea() + " square 
units.";
    return output;
}
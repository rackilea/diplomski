public void setSides(double newSide1, double newSide2, double newSide3) throws IllegalTriangleException {
    if (newSide1 + newSide2 > newSide3) 
        if (newSide1 + newSide3 > newSide2)
            if (newSide2 + newSide3 > newSide1)
                side1 = newSide1;

    side2 = newSide2;
    side3 = newSide3;
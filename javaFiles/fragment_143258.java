boolean areInvalidSides = false;

else { // line 92
    areInvalidSides = true;
    System.out.printf("Line %d - %s: the  side of the triangle should be an integer\n", lineNum, lineText.next());
}

if(!areInvalidSides){
    new Triangle(a[0],a[1],a[2]); // line 99
}
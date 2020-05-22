String cloneComparison = "Clone Comparision: ";
if ( older.getArea() == newer.getArea() ){
    cloneComparison = cloneComparison + "Equal";
} else {
    cloneComparison = cloneComparison + "Not Equal";
}
System.println(cloneComparison);
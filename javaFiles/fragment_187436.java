public int getIdForCategory(String category){
    if (category.equals("A")) return 1; //before it was category=="A"
    if (category.equals("B")) return 2;
    if (category.equals("C")) return 3;
    if (category.equals("D")) return 4;
    if (category.equals("E")) return 5;
    return 0;
}
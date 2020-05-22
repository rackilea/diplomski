public static Double getAUC(int i){
    Double temp = SaveMethod.AUC.get(i); // This can return null
    double AUC = temp.doubleValue(); // This was auto-unboxing

    Double boxed = Double.valueOf(AUC); // This was boxing
    return boxed;
}
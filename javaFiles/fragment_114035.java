public static void main(String[] args) {
    String filename = "APP";
    for (TypeFolio type : TypeFolio.values()) {
        System.out.println(filename.contains(type.name()));
    }
}


private enum TypeFolio {
    APD, APP;
}
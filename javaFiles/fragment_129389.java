public static void capitalize(ArrayList<String> names) {
    for (int i=0; i<names.size(); i++) {
        String capitalizedName = names.get(i).substring(0, 1).toUpperCase() + names.get(i).substring(1);
        names.set(i, capitalizedName);
    }
}
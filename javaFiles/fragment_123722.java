public Pays(String paysDescriptions) {
    String[] split_1 = paysDescriptions.split(",");
    for (String split : split_1) {
        String[] split_2 = split.split(":");
        for (String sp : split_2) {
            System.out.println(sp); // use sp.trim() if spaces after comma
                                    // not required.
        }
    }
}
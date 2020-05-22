public static void main(String[] args) {
    String[] fields = new String[] { //
            "ABL Cash Fund", //
            "AA(f)", //
            "Apr 18, 2016", //
            "10.4729" //
    };

    for (String field : fields) {
        System.out.format("%s\n%s\n\n", field, formatData(field));
    }
}
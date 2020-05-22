// Just a hint, define matches a List to be able to change the actuall class of the List more easy.
List<String> matches = new ArrayList<String>();
Pattern p = Pattern.compile("Acid Exposure \\(pH\\)");
for (List<String> row : twoDim) {
    boolean found = false;
    for (String cell : row) {
        if (p.matcher(cell).matches()) {
            System.out.println(matches);
            found = true;
            // Break out of the loop, no need to check for matches anymore
            break;
        }
    }
    if (found) {
        matches.addAll(row);
    }
}
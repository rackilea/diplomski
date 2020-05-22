for (int i = 0; i < searchFor.length; i++) {
    if (searchFor[i].isCaseSensitive()) {
        if (strLine.contains(searchFor[i].getTerm())) {
            counts[i]++;
        }
    }
    else {
        // this line was "borrowed" from Maroun Marouns answer (you can also use different methods to search case insensitive)
        if (Pattern.compile(strLine, Pattern.CASE_INSENSITIVE).matcher(searchFor[i].getTerm()).find()) { 
            counts[i]++;
        }
    }
}
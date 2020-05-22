private void addMinBetsV2(String aDataRow) {
    //[one or more digits]
    String numRegex = "(\\d)+"; 
    //[one or more digits],[one or more digits]
    String commaNumRegex = numRegex + "," + numRegex;

    if (aDataRow.matches(numRegex)) {
        Log.d("Split"," Match must be max bet = $ " + aDataRow);
    } else if (aDataRow.matches(commaNumRegex)) {
        String parts[] = aDataRow.    split("\\,");
        Log.d("Split"," Match must be min =  $" + parts[0]);
        Log.d("Split"," Match must be min color = " + parts[1]);
    }
}
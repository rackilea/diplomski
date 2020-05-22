//Populate ValueRange
static ValueRange requestBuilder( Report r, String range){
    ValueRange v = new ValueRange()
        .setValues(Arrays.asList(
            Arrays.asList(r.value1),
            Arrays.asList(r.value2),
            Arrays.asList(r.value3),
            Arrays.asList(r.value4),
            Arrays.asList(r.value5)
        ))
        .setMajorDimension("ROWS")
        .setRange(range)
    ;
    return v;
}
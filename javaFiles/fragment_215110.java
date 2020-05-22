private static String xyz(){
    switch(ENUMImpl.getCountry()) {
        case COUNTRY1:
            return "TMZ";
        default:
            return "NA";
    }
}

static {
    ABC = xyz();
}
try {
    switch(Codes.valueOf(stringArray[0])) {
        case keyword0:
           value = 0;
           break;
        case keyword1:
           value = 1;
           break;
    }
}
catch(IllegalArgumentException e) {
    value = parse(stringArray[0]);
}
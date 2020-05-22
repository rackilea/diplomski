public short normalize(short value) {
    short rawMax = // max from step1
    short targetMax = 8000;

    //This is the maximum volume reduction
    double maxReduce = 1 - targetMax/(double)rawMax;

    int abs = Math.abs(value);
    double factor = (maxReduce * abs/(double)rawMax);

    return (short) Math.round((1 - factor) * value); 
}
public int[] upSeries(int i) {
    assert i >= 0;        

    int[] array = new int[(i * (i+1)) / 2)];  // Standard Sum
    int seriesnum = 1;
    int seriesmax= 1;
    for (int index=0; index < array.length; index++) {
        array[index] = seriesnum;            

        if (seriesnum++ == seriesmax) {
            seriesnum = 1;
            seriesmax++;
        }
    }

    return array;
}
private int[] imageArray(String fullFilePath, int rows, int columns) throws Exception{
    int picRows = rows;
    int picColumns = columns;
    data = getPixelData(fullFilePath);

    //3 bands in TYPE_INT_RGB
    int NUM_BANDS = 3;
    int[] arrayImage = new int[picRows * picColumns * NUM_BANDS];

    for (int i = 0; i < picRows; i++)
    {
        for (int j = 0; j < picColumns; j++) {
            for (int band = 0; band < NUM_BANDS; band++)
                for (int k = 0; k < data.length; k++)
                    arrayImage[((i * picRows) + j)*NUM_BANDS + band] = data[k];
        }
    }
    return arrayImage;
}
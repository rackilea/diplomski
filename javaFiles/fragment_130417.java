for (int i = 0; i < array.length; i++) {
        twoDimensionalArray[chunkNumIndex][chunkIndex] = array[i];
        chunkIndex++;
        if (chunkIndex == chunkSize) {
            chunkNumIndex++;
            chunkIndex = 0;
        }
    }
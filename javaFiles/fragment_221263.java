if(visible){
    if (getNewRow) {
        if(j == 0){
        y = pdf.checkContentStream(y, 3, 10);
        y = pdf.rText(xCoord, y, 10, labelField, value, 
                  fieldSize);
        }
        else{
        y = pdf.rText(xCoord, y, 10, labelField, value, 
                  fieldSize);
        float min = y;
        for(int k = (j - 1); k >= 0; k--){
            if(y2[k] < min){
            min = y2[k];
            }
        }
        y = min;
        j = 0;
        }

    } else {
        if(j == 0){
        y = pdf.checkContentStream(y, 3, 10);
        }
        y2[j] = pdf.rText(xCoord, y, 10, labelField, value, 
                  fieldSize);
        j++;
    }
    }
    i++;
}
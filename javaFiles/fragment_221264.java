private float rText(String text, int width, float x, float y, int space,
        PDFont font, boolean isValue) throws Exception {
float newY = y;
int rowHeight = 0;
ArrayList<String> rowList = getRows(text, width, font);
if(isValue){
    for (String row : rowList) {
    if(rowHeight >= 10){
        newY = checkContentStream(newY - 10);
        newY = newY == 700 ? 680 : newY;
    }
    else{
    }
    content.beginText();
    content.moveTextPositionByAmount(x, newY);
    content.drawString(row);
    content.endText();
    rowHeight = rowHeight + 10;
    }
}
else{
    for(String row : rowList){
    content.beginText();
    content.moveTextPositionByAmount(x, newY - rowHeight);
    content.drawString(row);
    content.endText();
    rowHeight = rowHeight + 10;
    }
    newY -= (rowHeight - 9);
}
return newY;
}
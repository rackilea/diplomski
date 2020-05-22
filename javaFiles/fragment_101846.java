int originalImgWidth  = bitmap.getWidth();
int originalImgHeight  = bitmap.getHeight();

float scale = screenHeight * 1f / originalImgHeight;  
// since your img will fill the screen vertically

float marginSize =  (screenWidth - (originalImgWidth * scale)) /2;
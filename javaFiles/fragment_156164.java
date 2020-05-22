float maxRatio = maxWidth/maxHeight;
if(maxRatio > ratio) {
    width = maxWidth;
    height = width / ratio;
} else {
    height = maxHeight;
    width = height * ratio;
}
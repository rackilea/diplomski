width = 1000;
cameraToBottomLeft = (-1,1,1);
bottomLeftToBottomRight = (2,0,0);

for (x = 0; x < width; x++) {
    ray = cameraToBottomLeft + (x/width) * bottomLeftToBottomRight;
    ...
}
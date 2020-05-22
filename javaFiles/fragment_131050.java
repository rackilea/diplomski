function onClick (evt) {
    var x = getEventOffsetFromImageLeft(evt);
    var y = getEventOffsetFromImageTop(evt);

    var clickedLon = topX + x * degreesPerPixelX;
    var clickedLat = bottomY + y * degreesPerPixelY;
}
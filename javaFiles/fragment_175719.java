float xScale = 1.0f;
float yScale = 1.0f;
if (imgAspectRatio > viewAspectRatio) {
    yScale = viewAspectRatio / imgAspectRatio;
} else {
    xScale = imgAspectRatio / viewAspectRatio;
}
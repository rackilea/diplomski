int gray = (int) Math.round((kDEvalues[x][y] - (-1)) * 127.5);
// limit range to 0-255
gray = Math.min(gray, 255);
gray = Math.max(gray, 0);
// copy gray value to r, g and b channel
int rgb = (gray << 16) | (gray << 8) | gray;
image.setRGB(x, y, rgb);
public static void fill(String[] image, int x, int y, char c) {
    char old = (image[y]).charAt(x);

    image[y] = (image[y]).substring(0, x) + c + (image[y]).substring(x + 1);

    if ((x + 1) < image[0].length() && 
            image[y].charAt(x + 1) == old) {
        fill(image, x + 1, y, c);
    }

    if ((x - 1) >= 0 &&
            image[y].charAt(x - 1) == old) {
        fill(image, x - 1, y, c);
    }

    if ((y - 1) >= 0 &&
            image[y - 1].charAt(x) == old) {
        fill(image, x, y - 1, c);
    }

    if ((y + 1) < image.length &&
            image[y + 1].charAt(x) == old) {
        fill(image, x, y + 1, c);
    }
}
if (!catParts.isEmpty()) {
    catParts.remove(0);
}
if (!catParts.isEmpty()) {
    head = catParts.get(catParts.size() - 1);
    if (mouse != null) {
        if (head.x == mouse.x && head.y == mouse.y) {
            score++;
            tailLength++;
            mouse.setLocation(dim.width / SCALE, dim.height / SCALE);
        }
    }
}
for (int i = 0; i < 4; i++) {
    g.drawLine(i * width, 0, i * width, getHeight());
}

for (int i = 0; i < 11; i++) {
    g.drawLine(0, i * height, getWidth(), i * height);
}
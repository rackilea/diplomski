float offSet = 36;
float gutter = 23;
float columnWidth = (PageSize.A4.getWidth() - offSet * 2) / 2 - gutter;
float columnHeight1 = renderer.getY() - offSet * 2;
Rectangle[] columns1 = {
    new Rectangle(offSet, offSet, columnWidth, columnHeight1),
    new Rectangle(offSet + columnWidth + gutter, offSet, columnWidth, columnHeight1)};
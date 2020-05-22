...
columns2 = new Rectangle[2];
columns2[0] = new Rectangle(offSet, offSet, columnWidth, columnHeight2);
columns2[1] = new Rectangle(offSet + columnWidth + gutter, offSet, columnWidth, columnHeight2);
document.setRenderer(new CustomColumnDocumentRenderer(document, columns1, columns2));
document.add(new AreaBreak(AreaBreakType.NEXT_PAGE)); // <---
for(int i = 0; i < 5; i++) {
    for(String loremipsum : loremipsums) {
        document.add(new Paragraph(loremipsum));
    }
}
...
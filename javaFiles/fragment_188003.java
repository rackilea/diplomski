totalHeight += fontHeight;
if(totalHeight+margin>=a4Height){
    page = new PDPage();
    doc.addPage(page);
    totalHeight = margin;
}
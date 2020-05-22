if(list.contains(list.get(1))) {
     pageInfo = new PdfDocument.PageInfo.Builder(, 6000, 2).create();
    page = document.startPage(pageInfo);
    canvas = page.getCanvas();
    ....
}
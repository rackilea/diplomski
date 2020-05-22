if(list.contains(list.get(0))) {
    PdfDocument.PageInfo pageInfo=new PdfDocument.PageInfo.Builder(300, 6000, 1).create();
    PdfDocument.Page page=document.startPage(pageInfo);
    Canvas canvas=page.getCanvas();
    ....
 }
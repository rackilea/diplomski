// Specify the painter
painter = new Printing(printerData);
pj.setPrintable(painter);
PageFormat pf0 = pj.defaultPage();
Paper p = pf0.getPaper();
p.setImageableArea(0, 0, pf0.getWidth(), pf0.getHeight());
pf0.setPaper(p);
pj.validatePage(pf0);
Book book = new Book();
book.append(painter, pj.validatePage(pf0));
pj.setPageable(book);
pj.print();
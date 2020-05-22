public void onModuleLoad()
    {
        Label a = new Label("asad");
        Label b = new Label("ad");
        Label c = new Label("qwad");
        Label w = new Label("zxd");
        a.setPixelSize(200, 200);
        a.getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
        a.getElement().getStyle().setBorderWidth(1, Unit.PX);
        b.setPixelSize(200, 200);
        c.setPixelSize(200, 200);
        w.setPixelSize(200, 200);
        a.getElement().getStyle().setBackgroundColor("red");
        b.getElement().getStyle().setBackgroundColor("yellowgreen");
        c.getElement().getStyle().setBackgroundColor("lightblue");
        w.getElement().getStyle().setBackgroundColor("grey");
        DragFlexTable d = new DragFlexTable();
        d.setWidget(0, 0, a);
        d.setWidget(0, 1, b);
        d.setWidget(1, 0, c);
        d.setWidget(1, 1, w);
        d.setCellPadding(20);
        RootPanel.get().add(d);
    }
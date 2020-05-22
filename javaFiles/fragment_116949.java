Label l = new Label("$");
TextBox b = new TextBox();
l.getElement().addClassName("dollarlabel");
b.getElement().addClassName("dollarinput");
RootPanel.get().add(b);
RootPanel.get().add(l);
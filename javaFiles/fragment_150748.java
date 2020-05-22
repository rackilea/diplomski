Form hi = new Form("Visible", BoxLayout.y());

Button r1 = new Button("Regular");
Button invisible = new Button("Invisible");
invisible.setVisible(false);
Button r2 = new Button("Regular");

Button r3 = new Button("Regular");
Button hidden = new Button("Hidden");
hidden.setHidden(true);
Button r4 = new Button("Regular");

hi.add(BoxLayout.encloseX(r1, invisible, r2));
hi.add(BoxLayout.encloseX(r3, hidden, r4));

hi.show();
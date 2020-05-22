myForm.setScrollable(false);
Button ad = new Button(adAction);
myForm.setLayout(new BorderLayout());
myForm.addComponent(BorderLayout.SOUTH, ad);
Container actualContent = new Container();
myForm.addComponent(BorderLayout.CENTER, actualContent);
actualContent.setScrollableY(true);
//make the elements
MyWidget widget = new MyWidget();
//attach them to the dom (note that if you attach to a different
//                        parent, that parent too must be attached
//                        and so on).
RootPanel.get().add(widget);
//now that we are attached, run the setup code!
widget.doSomeJsStuff();
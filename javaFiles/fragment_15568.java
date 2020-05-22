TitledPane tp = new TitledPane();

Accordion acc = new Accordion(tp);
System.out.println(acc.getChildrenUnmodifiable().size()); // 0

Scene scene = new Scene(acc);

// layout happens here
acc.applyCss();
acc.layout();

System.out.println(acc.getChildrenUnmodifiable().size()); // 1
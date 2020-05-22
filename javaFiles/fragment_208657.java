aRadio = new RadioButton("A Branch");
aRadio.setToggleGroup(sumGroup);
layout.setConstraints(aRadio, 1, 3);

bRadio = new RadioButton("B Branch");
bRadio.setToggleGroup(sumGroup);
layout.setConstraints(bRadio, 1, 4);

cRadio = new RadioButton("C Branch");
cRadio.setToggleGroup(sumGroup);
layout.setConstraints(cRadio, 1, 5);
Element aff = doc.createElement("aff");

Element label1 = doc.createElement("label");
label1.setTextContent("1");
Text text1 = doc.createTextNode("some text");

Element label2 = doc.createElement("label");
label2.setTextContent("2");
Text text2 = doc.createTextNode("another text");


aff.appendChild(label1);
aff.appendChild(text1);
aff.appendChild(label2);
aff.appendChild(text2);
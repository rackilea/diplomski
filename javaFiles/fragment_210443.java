//get the split point:
int prevSplitOffset = 0;
Matcher m = Pattern.compile("\\[(\\d+)\\]").matcher(textNode.getData());
while (m.find()) {
  // get the text and split it:
  Text number = textNode.splitText(m.start(1) - prevSplitOffset);
  textNode = number.splitText(m.group(1).length());

  // Replace the number with a new DOM node:
  Element xref = document.createElement("xref");
  xref.setAttribute("rid", "bib" + m.group(1));
  xref.setAttribute("ref-type", "bibr");
  number.getParentNode().replaceChild(xref, number);
  xref.appendChild(number);
  prevSplitOffset = m.end(1);
}
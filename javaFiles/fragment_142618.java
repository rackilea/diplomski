final NodeList<Element> tdElems = 
    simplePager.getElement().getElementsByTagName("td");

for (int i = 0; i < tdElems.getLength(); i++) {

  final String toolTipText;

  if (i == 0)
    toolTipText = "First page";
  else if (i == 1)
    toolTipText = "Previous page";
  else if (i == 2)
    continue; /* This is the middle td - no button */
  else if (i == 3)
    toolTipText = "Next page";
  else if (i == 4)
    toolTipText = "Last page";
  else
    continue;

  tdElems.getItem(i).setTitle(toolTipText);
}
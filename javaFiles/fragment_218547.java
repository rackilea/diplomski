Element curElement = (Element)items.item(i);
 // Start new code
 Node prev = curElement.getPreviousSibling();
 if (prev != null && 
     prev.getNodeType() == Node.TEXT_NODE &&
     prev.getNodeValue().trim().length() == 0) {
     items_parent.removeChild(prev);
 }
 // End new code
 items_parent.removeChild(curElement);
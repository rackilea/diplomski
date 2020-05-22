NodeList partNoElements = document.getElementsByTagName("PartNo");
for (int i = 0; i < partNoElements.getLength(); i++)
{
  Element partNoElement = partNoElements.item(i);

  PartNo[i].setText(partNoElement.getTextContent());

  Element modelElement = (Element)partNoElement.getNextSibling();
  if (modelElement != null && modelElement.getNodeName().equals("Model"))
  {
    Model[i].setText(modelElement.getTextContent());
  }
}
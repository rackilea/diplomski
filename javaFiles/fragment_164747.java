@Test
public void IfColumnDescriptionGivenThenGenerateAccordingField() {
    Element element = XSDCreator.createFieldElement(doc, 1, ";");
    element.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
    String output = XSDCreator.renderToString(element);
    assertEquals(output, "Here comes the output");
}
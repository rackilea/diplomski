for (int i = 0; i < PathsCount.getLength(); i++)
{
    Node tPathsChild = PathsCount.item(i);
    System.out.println(i);

    // get the number of TerminatedLayers elements.
    XPathExpression exprueba = xpath.compile("Topology/LayerSet/TerminatedLayers");
    NodeList Count = (NodeList) exprueba.evaluate(tPathsChild, XPathConstants.NODESET);
    System.out.println("Hay " + Count.getLength());
    int countvar = Count.getLength();

    // remove this child if there are only 1 of them.
    if (countvar == 1) {
        tPathsChild.getParentNode().removeChild(tPathsChild);
    }
}
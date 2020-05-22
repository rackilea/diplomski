public class CompareStructureOnlyListener implements DifferenceListener {

  private IgnoreTextAndAttributeValuesDifferenceListener delegate =
      new IgnoreTextAndAttributeValuesDifferenceListener();

  @Override
  public int differenceFound(Difference difference) {
    int delegateResult = delegate.differenceFound(difference);

    if (delegateResult == DifferenceListener.RETURN_ACCEPT_DIFFERENCE) {
      // Delegate thinks there is a difference, let's confirm

      if (difference.getId() == DifferenceConstants.HAS_CHILD_NODES_ID) {
        Node controlNode = difference.getControlNodeDetail().getNode();
        Node testNode = difference.getTestNodeDetail().getNode();

        Node nodeToTest = (controlNode.hasChildNodes()) ? controlNode : testNode;

        // If there is only a difference of one node and that node is a text
        // node, then ignore it
        if (nodeToTest.getChildNodes().getLength() == 1
            && nodeToTest.getFirstChild() instanceof Text) {
          return DifferenceListener.RETURN_IGNORE_DIFFERENCE_NODES_SIMILAR;
        } else {
          return DifferenceListener.RETURN_ACCEPT_DIFFERENCE;
        }
      }
    }  
    return delegateResult;
  }

  @Override
  public void skippedComparison(Node control, Node test) {
    // Does nothing
  }
}
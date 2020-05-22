/**
    Text string position comparator.
   */
  private static class TextStringPositionComparator
    implements Comparator<ITextString>
  {
    /**
      Gets whether the specified boxes lay on the same text line.
    */
    public static boolean isOnTheSameLine(
      Rectangle2D box1,
      Rectangle2D box2
      )
    {
      /*
        NOTE: In order to consider the two boxes being on the same line,
        we apply a simple rule of thumb: at least 25% of a box's height MUST
        lay on the horizontal projection of the other one.
      */
      double minHeight = Math.min(box1.getHeight(), box2.getHeight());
      double yThreshold = minHeight * .75;
      return ((box1.getY() > box2.getY() - yThreshold
          && box1.getY() < box2.getMaxY() + yThreshold - minHeight)
        || (box2.getY() > box1.getY() - yThreshold
          && box2.getY() < box1.getMaxY() + yThreshold - minHeight));
    }

    @Override
    public int compare(
      ITextString textString1,
      ITextString textString2
      )
    {
      Rectangle2D box1 = textString1.getBox();
      Rectangle2D box2 = textString2.getBox();
      if(isOnTheSameLine(box1,box2))
      {
        /*
          [FIX:55:0.1.3] In order not to violate the transitive condition, equivalence on x-axis
          MUST fall back on y-axis comparison.
        */
        int xCompare = Double.compare(box1.getX(), box2.getX());
        if(xCompare != 0)
          return xCompare;
      }
      return Double.compare(box1.getY(), box2.getY());
    }
  }
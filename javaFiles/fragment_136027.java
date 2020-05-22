/**
    * Returns the new position to put the divider at based on
    * the passed in MouseEvent.
    */
    protected int positionForMouseEvent(MouseEvent e) {
      int newX = (e.getSource() == BasicSplitPaneDivider.this) ?
                  (e.getX() + getLocation().x) : e.getX();

      newX = Math.min(maxX, Math.max(minX, newX - offset));
      return newX;
    }
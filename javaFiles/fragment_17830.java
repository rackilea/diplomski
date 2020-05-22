// returns the visible part of any component in its own coordinates
      // available for all components
      Rectangle visible = table.getVisibleRect();
      // special service method in JViewport, returning the visible portion
      // of its single child in the coordinates of the child
      Rectangle viewRect = ((Viewport) (table.getParent()).getViewRect();
      // both are the same 
      visible.equals(viewRect)
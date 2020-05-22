if (redrawRequired) {
        // Redraw the entire content.
        SafeHtmlBuilder sb = new SafeHtmlBuilder();
        view.replaceAllChildren(newState.rowData, selectionModel, newState.keyboardStealFocus);
        view.resetFocus();
      } else if (range0 != null) {
        // Surgically replace specific rows.

        // Replace range0.
        {
          int absStart = range0.getStart();
          int relStart = absStart - pageStart;
          SafeHtmlBuilder sb = new SafeHtmlBuilder();
          List<T> replaceValues = newState.rowData.subList(relStart, relStart + range0.getLength());
          view.replaceChildren(replaceValues, relStart, selectionModel, newState.keyboardStealFocus);
        }

        // Replace range1 if it exists.
        if (range1 != null) {
          int absStart = range1.getStart();
          int relStart = absStart - pageStart;
          SafeHtmlBuilder sb = new SafeHtmlBuilder();
          List<T> replaceValues = newState.rowData.subList(relStart, relStart + range1.getLength());
          view.replaceChildren(replaceValues, relStart, selectionModel, newState.keyboardStealFocus);
        }

        view.resetFocus();
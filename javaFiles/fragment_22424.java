checks[i].addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent event) {
         // your code here...

         // get the current checkbox/radio button from the event:
         Widget src = event.widget;
         // ...
      }
    });
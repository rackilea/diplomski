addDomHandler(new ClickHandler() {
     @Override
     public void onClick(ClickEvent event) {
       if (isActive(Cell.this)) {
         setSelected(Cell.this);
       }
     }
  }, ClickEvent.getType());
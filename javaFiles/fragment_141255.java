items.add(new Product("test", "test test"));

        grid = new Grid<Product>();

        grid.getEditor().setBuffered(true);
        grid.getEditor().setEnabled(false);

        grid.removeAllColumns();

        // Important! Propagate events from components to Grid
        grid.addComponentColumn(this::buildAddButton).setHandleWidgetEvents(true).setId("buttonClick");

        TextField nameField = new TextField();
        TextField descriptionField = new TextField();

        grid.addColumn(Product::getName).setCaption("Name").setEditorComponent(nameField, Product::setName)
                .setExpandRatio(1);
        grid.addColumn(Product::getDescription).setCaption("Description")
                .setEditorComponent(descriptionField, Product::setDescription).setExpandRatio(1);

        //Once close editor--> Disable it
        grid.getEditor().addSaveListener(event -> {
            grid.getEditor().setEnabled(false);

        });
        grid.getEditor().addCancelListener(e->{
            grid.getEditor().setEnabled(false);
        });
        //THIS IS WHERE ALL THE LOGIC IS HAPPENING
        grid.addItemClickListener(item->{
            //If the button column is clicked
           if("buttonClick".equals(item.getColumn().getId())){
               //Regual click--> update content; also fired twice before editor is opened
               if(!item.getMouseEventDetails().isDoubleClick()){
                  addButtonClicked(item.getItem());
               }
               //If Double click is detected, just opened editor. The data is already updated
               else{
                   grid.getEditor().setEnabled(true);
                   grid.getEditor().editRow(item.getRowIndex());
               }
            }
           //In all the other cases, when double click is detected--> open editor
           else if(item.getMouseEventDetails().isDoubleClick()){
               grid.getEditor().setEnabled(true);
               grid.getEditor().editRow(item.getRowIndex());
           }
        });

        grid.setItems(items);
        addComponent(grid);
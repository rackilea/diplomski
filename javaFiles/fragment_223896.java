@Override
    public void startEdit() {
        super.startEdit();
        PopOver popOver = new PopOver();
        popOver.setAutoHide(true);
        // first set auto fix to false 
        // to manually set the arrow location
        popOver.setAutoFix(false);   
        PopupController sc = new PopupController(allItems, new ArrayList<>(getItem()));

        // set a specific height for our pane
        final double paneHeight = 300;

        StackPane popOverPane = new StackPane(sc.getPane());
        popOverPane.setPrefHeight(paneHeight);

        popOver.setContentNode(popOverPane);
        popOver.setOnHiding(event -> commitEdit(sc.getItems()));

        // find coordinates relative to the screen
        Bounds screenBounds = this.localToScreen(this.getBoundsInLocal());

        // get our current y position ( on screen )
        int yPos = (int) screenBounds.getMinY();

        // get screen size 
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        int screenHeight = (int) primaryScreenBounds.getHeight();

        // if the PopOver height + the current position is greater than
        // the max screen's height then set the arrow position to bottom left
        if(screenHeight < yPos + paneHeight) {
            popOver.setArrowLocation(ArrowLocation.LEFT_BOTTOM);
        }

        popOver.show(this);
    }
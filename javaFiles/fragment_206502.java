HorizontalPanel horizontalPanel = new HorizontalPanel();

Button button = new Button("Clear");
button.addClickHandler(new ClickHandler()
{
    //@Override
    public void onClick(ClickEvent event)
    {
        // Remember the values before hiding the popup.
        Element cellParent = lastParent;
        Date oldValue = lastValue;
        Object key = lastKey;
        int index = lastIndex;
        int column = lastColumn;
        panel.hide();

        // Update the cell and value updater.
        Date date = null;
        setViewData(key, date);
        setValue(new Context(index, column, key), cellParent, oldValue);
        if (valueUpdater != null) {
          valueUpdater.update(date);
        }
    }
});

horizontalPanel.add(button);
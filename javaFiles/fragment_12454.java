Button button1 = new Button();
    button1.setCaption(ResourceBundle.getBundle("yourfile",your_locale).getLabel("fruit.banana"));
    button1.setIcon(CommonIcons.ADD);
    button1.addListener(new ClickListener()
    {
        private static final long serialVersionUID = 7855693595481663167L;

        @Override
        public void buttonClick(ClickEvent event)
        {
            handleAddButton();
        }
    });
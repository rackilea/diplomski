private AjaxEditableLabelColumn<User, String> createMyEditableColumn(String propertyExpression, boolean sortable) {

        final IModel<String> cssModel = Model.of("bkg-default");
        AjaxEditableLabelColumn<User, String> column = new AjaxEditableLabelColumn<User, String>(propertyExpression, sortable) {

        private static final long serialVersionUID = 1L;

           @Override
           protected void onChange(AjaxRequestTarget target, IModel<User> model) {

                User newRecord = model.getObject();

                if (newRecord.hasChanged()) {
                    if (newRecord.isRight()) {
                        cssModel.setObject("bkg-green");
                    } else {
                        cssModel.setObject("bkg-red");
                    }
                } else {
                    cssModel.setObject("bkg-default");
                }
           }
           // The following line is unnccessary if you already add 
           // component for to be render in AjaxEditableLabelColumn
           target.add(this);

       };
       column.add(new AttributeModifier("css", cssModel));
       return column;
    }
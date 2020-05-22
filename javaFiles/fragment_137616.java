MethodExpression methodExpression = 
    application.getExpressionFactory().createMethodExpression(
         FacesContext.getCurrentInstance().getELContext(), 
         "#{PrismBacking.onItemClick}", 
         null, 
         new Class[] { ActionEvent.class });
menuItem.setActionExpression(methodExpression);
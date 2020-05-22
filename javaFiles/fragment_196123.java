public static MethodExpression createAction(String actionExpression, Class<?> returnType) {
    FacesContext context = FacesContext.getCurrentInstance();
    return context.getApplication().getExpressionFactory()
        .createMethodExpression(context.getELContext(), actionExpression, returnType, new Class[0]);
}

public static MethodExpressionActionListener createActionListener(String actionListenerExpression) {
    FacesContext context = FacesContext.getCurrentInstance();
    return new MethodExpressionActionListener(context.getApplication().getExpressionFactory()
        .createMethodExpression(context.getELContext(), actionListenerExpression, null, new Class[] {ActionEvent.class}));
}
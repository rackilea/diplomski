public void cancelar(){
    fechar();
    //Limpa todos os campos do formulário
    FacesContext context = FacesContext.getCurrentInstance();
    Application application = context.getApplication();
    ViewHandler viewHandler = application.getViewHandler();
    UIViewRoot viewRoot = viewHandler.createView(context, context
            .getViewRoot().getViewId());
    context.setViewRoot(viewRoot);
    context.renderResponse();
}
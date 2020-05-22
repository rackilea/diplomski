public void printImage(ActionEvent event) {
        String taskflowDocument = "/WEB-INF/album-printtask-flow.xml";
        String taskflowId = "album-printtask-flow";        
        Integer parentStatus = (Integer)event.getComponent().getAttributes().get("parentStatus");
        Integer childStatus = (Integer)event.getComponent().getAttributes().get("childStatus");        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("image", getAlbumDetailCurrent().get(parentStatus).get(childStatus));        
        Map<String, Object> params = new HashMap<String, Object>();        
        String taskflowURL = ControllerContext.getInstance().getTaskFlowURL(false,new TaskFlowId(taskflowDocument,taskflowId),params);
        FacesContext context = FacesContext.getCurrentInstance();
        ExtendedRenderKitService service = Service.getRenderKitService(context, ExtendedRenderKitService.class);
        StringBuilder script = new StringBuilder();
        script.append("window.open(\""+taskflowURL+"\");");
        service.addScript(FacesContext.getCurrentInstance(), script.toString());  
}
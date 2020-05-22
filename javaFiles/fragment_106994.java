private DeveloperEditor developerEditor;

 public void setDeveloperEditor(DeveloperEditor developerEditor){
    this.developerEditor = developerEditor;
    developerEditor.setGameOrganizer(gameOrganizer);
}

 @Override
protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
    binder.registerCustomEditor(Developer.class, developerEditor);
}
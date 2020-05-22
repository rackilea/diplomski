@Inject
EModelService modelService;
@Inject
MApplication app;


MUIElement window = modelService.find("window id", app);

window.setToBeRendered(true);
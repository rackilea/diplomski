@ProcessAdditions
private void switchPerspective(final MApplication pApplication,
                               final IApplicationContext pApplicationContext,
                               final EModelService pModelService) {

  final MWindow _window =
     (MWindow) pModelService.find(PluginIdConstants.WINDOW_ID_FOR_MAIN, pApplication);

  final String _appName = pApplicationContext.getBrandingName();
  initializeWindowTitle(_window, _appName);

  final MPerspectiveStack pPerspectiveStack =
     (MPerspectiveStack) pModelService.find(PluginIdConstants.PERSPECTIVE_STACK_ID_FOR_MAIN,
        pAnwendung);

  for (final MPerspective _perspective : pPerspectiveStack.getChildren()) {
     if (_perspektive.getElementId().equalsIgnoreCase(this.startingPerspectiveId)) {
        pPerspectiveStack.setSelectedElement(_perspective);
        break;
     }
  }
}
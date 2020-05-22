import  org.eclipse.ui.intro.config.IIntroAction;

public abstract class ShowPerspectiveIntroAction implements IIntroAction {

  private static final Logger LOG = Logger.getLogger(ShowPerspectiveIntroAction.class);

  @Override
  public void run(IIntroSite arg0, Properties arg1) {
    // Switch to perspective
    final IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
    IPerspectiveDescriptor activePerspective = workbenchWindow.getActivePage().getPerspective();
    if(activePerspective==null || !activePerspective.getId().equals(getPerspectiveId())) {           
        Display.getCurrent().asyncExec(new Runnable() {
            public void run() {
                // switch perspective           
                try {
                    workbenchWindow.getWorkbench().showPerspective(getPerspectiveId(),workbenchWindow);
                } catch (WorkbenchException e) {
                    LOG.error("Can not switch to perspective: " + getPerspectiveId(), e);
                }
            }
        });
    }

    // close intro/welcome page
    final IIntroPart introPart = PlatformUI.getWorkbench().getIntroManager().getIntro(); 
    PlatformUI.getWorkbench().getIntroManager().closeIntro(introPart);

    // Show CheatSheet
    ShowCheatSheetAction action = new ShowCheatSheetAction("Show security assessment cheat sheet", getCheatSheetId());
    action.run();
  }

  public abstract String getCheatSheetId();
  public abstract String getPerspectiveId();
}
public class MyAction extends AnAction {
    public void actionPerformed(AnActionEvent e) {
      VirtualFile vFile = e.getData(PlatformDataKeys.VIRTUAL_FILE);
      String fileName = vFile != null ? vFile.getName() : null;
    } 
  }
@Override
public void update(@NotNull AnActionEvent e) {

    final Presentation presentation = e.getPresentation();
    final Project project = e.getProject();

    if (project == null) {
        presentation.setEnabledAndVisible(false);
        return;
    }
    presentation.setEnabledAndVisible(true);
}
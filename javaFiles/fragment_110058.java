final Display display = new Display();
final Shell shell = new Shell(display);
shell.setText("Git ToDo");
FillLayout layout = new FillLayout();
shell.setLayout(layout);

Composite composite = new Composite(shell, SWT.NONE);
composite.setLayout(new FillLayout()); // Possible missing layout?

final GitToDoTree tableViewer = new GitToDoTree(composite);
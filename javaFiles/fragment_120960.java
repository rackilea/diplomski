import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class TestDialog extends Dialog
{
  public TestDialog(final Shell parentShell)
  {
    super(parentShell);
  }


  @Override
  protected Control createDialogArea(final Composite parent)
  {
    final Composite body = (Composite)super.createDialogArea(parent);

    final TableViewer viewer = new TableViewer(body, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);

    viewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    // TODO: Set TableViewer content and label providers
    // TODO: Set TableViewer input

    return body;
  }
}
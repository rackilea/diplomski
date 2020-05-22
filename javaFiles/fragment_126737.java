import org.eclipse.swt.*;
import org.eclipse.swt.dnd.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class DragTransferTest {

    public static void main(String[] args) {
        final Display display = new Display();
        final Shell shell = new Shell(display);
        shell.setLayout(new FillLayout());
        final Label label = new Label(shell, SWT.BORDER);
        label.setText("Drop file here to start");

        final Transfer[] types = new Transfer[] { new ByteArrayTransfer() {

            byte[] lastDrop;

            @Override
            protected Object nativeToJava(TransferData transferData) {
                byte[] data = (byte[]) super.nativeToJava(transferData);
                lastDrop = data;
                return null;
            }

            @Override
            protected void javaToNative(Object object, TransferData transferData) {
                if (lastDrop == null) {
                    DND.error(DND.ERROR_INVALID_DATA);
                }
                super.javaToNative(lastDrop, transferData);
            };

            @Override
            protected String[] getTypeNames() {
                return new String[] { "Shell IDList Array" };
            }

            @Override
            protected int[] getTypeIds() {
                return new int[] { registerType("Shell IDList Array") };
            }
        } };
        final int operations = DND.DROP_LINK | DND.DROP_COPY | DND.DROP_MOVE;

        final DragSource source = new DragSource(label, operations);
        source.setTransfer(types);

        DropTarget target = new DropTarget(label, -1);
        target.setTransfer(types);

        shell.setSize(200, 200);
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }
}
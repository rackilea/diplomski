import com.example.dnd.model.Doctor;
import java.awt.datatransfer.Transferable;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.TransferHandler;

public class DoctorTransferHandler extends TransferHandler {

  @Override
  public boolean canImport(TransferSupport support) {
    return support.isDrop() && support.isDataFlavorSupported(DoctorTransferable.DOCTOR_FLAVOR);
  }

  @Override
  public boolean importData(TransferSupport support) {
    if (!canImport(support)) {
      return false;
    }
    JTable table = (JTable) support.getComponent();
    DoctorTableModel model = (DoctorTableModel) table.getModel();
    try {
      Transferable transferable = support.getTransferable();
      ArrayList<Doctor> list =
          (ArrayList<Doctor>) transferable.getTransferData(DoctorTransferable.DOCTOR_FLAVOR);
      model.addAll(list);
      return true;
    } catch (Exception ex) {
      ex.printStackTrace();
      return false;
    }
  }

  @Override
  public int getSourceActions(JComponent c) {
    return COPY_OR_MOVE;
  }

  @Override
  protected Transferable createTransferable(JComponent c) {
    JTable table = (JTable) c;
    DoctorTableModel model = (DoctorTableModel) table.getModel();
    return new DoctorTransferable(model.getAll(table.getSelectedRows()));
  }

  @Override
  protected void exportDone(JComponent source, Transferable data, int action) {
    if (action == MOVE) {
      JTable table = (JTable) source;
      DoctorTableModel model = (DoctorTableModel) table.getModel();
      model.removeAll(model.getAll(table.getSelectedRows()));
    }
  }
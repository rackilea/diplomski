import com.example.dnd.model.Doctor;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class DoctorTransferable implements Transferable {

  public static final DataFlavor DOCTOR_FLAVOR;

  static {
    try {
      DOCTOR_FLAVOR = new DataFlavor("application/x-my-mime-type; class=java.util.ArrayList");
    } catch (ClassNotFoundException ex) {
      throw new RuntimeException(ex);
    }
  }

  private final ArrayList<Doctor> doctors;

  public DoctorTransferable(Collection<? extends Doctor> doctors) {
    this.doctors = new ArrayList<>(doctors);
  }

  @Override
  public DataFlavor[] getTransferDataFlavors() {
    return new DataFlavor[]{DOCTOR_FLAVOR};
  }

  @Override
  public boolean isDataFlavorSupported(DataFlavor flavor) {
    return DOCTOR_FLAVOR.equals(flavor);
  }

  @Override
  public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
    if (DOCTOR_FLAVOR.equals(flavor)) {
      return doctors;
    }
    throw new UnsupportedFlavorException(flavor);
  }

}
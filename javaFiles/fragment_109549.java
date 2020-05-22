public interface ReportService extends Remote {
  public JasperPrint fillReport(final JasperReport report, final Map reportParameters)throws RemoteException, JRException;
}

public class ReportServiceImpl implements ReportService {

  final Connection connection;

  public ReportServiceImpl(final Connection connection) {
    this.connection = connection;
  }

  public JasperPrint fillReport(final JasperReport report, final Map reportParameters) throws RemoteException, JRException {
    return JasperFillManager.fillReport(report, reportParameters, connection);
  }
}
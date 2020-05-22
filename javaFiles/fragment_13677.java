public interface LogDAO extends AbstractDAO<TblLogEntity, TblLogEntity1>
{
    void logEvent(String id, String action, String oldValue, String newValue);
}

And you can get data to log like this:
LtblTableEntity e;
logDAO.logEvent(e.getId().toString(), "action", e.getName(), "NewName");
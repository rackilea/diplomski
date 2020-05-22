@Component
    public class RexFieldTypeDAO {

    @Resource(name = "REXDataSource")
    private DataSource lyxsrvREXDataSource;

// ------------------------------------------------------------------------

public RexFieldTypeDAO() {
}

// ------------------------------------------------------------------------

public RecordSetDTO getFieldTypes(int recoType) {
    RecordSetDTO res;

    GetFieldTypeStoredProcedure proc = new GetFieldTypeStoredProcedure(lyxsrvREXDataSource);
    res = proc.execute(recoType);

    return res;
}

/**
 * Private class used to access Stored Procedure.
 */
private static class GetFieldTypeStoredProcedure extends StoredProcedure {
    private static final String SQL = "rex_datainterface.getfieldtype";

    public GetFieldTypeStoredProcedure(DataSource dataSource) {
        super(dataSource, SQL);
        setFunction(true);
        declareParameter(new SqlOutParameter("result", OracleTypes.CURSOR, new RecordSetDTORowMapper()));
        declareParameter(new SqlParameter("recoType", OracleTypes.NUMBER));
        compile();
    }

    public List<RecordSetDTO> execute(int recoType) {
        Map<String, Object> inputs = new HashMap<String, Object>();

        inputs.put("recoType", recoType);
        return (List<RecordSetDTO>)super.execute(inputs).get("result");
    }

}
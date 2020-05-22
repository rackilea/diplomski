@Component
public class ItemInsert extends StoredProcedure {
public static final String SPROC_NAME = "schema.oracle_pkg.proc_name";
public static final String INPUT_PARAM = "input_prm_name";
public static final String OUPUT_PARAM = "output_prm_name";

@Inject
public ItemInsert(DataSource ds) {
super(ds, SPROC_NAME);
declareParameter(new SqlParameter(INPUT_PARAM, Types.VARCHAR));
declareParameter(new SqlOutParameter(OUTPUT_PARAM, Types.NUMERIC));
compile();
}

public Item insert(Item item)
  throws DataAccessException {
Map<String, Object> inputs = new HashMap<String, Object>();
inputs.put(INPUT_PARAM, item.getSomething());
Map<String, Object> output = super.execute(inputs);
Object newId = output.get(OUTPUT_PARAM);
if (newId != null) {
  item.setId(Long.parseLong(newId.toString()));
}
return item;
}
@ManagedBean(name="persons")
@SessionScoped
public class Persons {
  ResultSet resultSet = null;
  DataDAO datadao = new DataDAO();
  public List<JSONObject> people = JsonServices.getFormattedResult(datadao.getResultSet());
  /** getter and setter **/
}
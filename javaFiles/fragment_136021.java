private static final class CompetitionMapExtractor implements ResultSetExtractor<List<Competition>> {
@Override
public List<Competition> extractData(ResultSet rs) throws SQLException {
  List<Competition> result = new ArrayList<>(rs.getCount());
  int previousCompetitionId = NEVER_EXIST; // normally -1 is good enough
  while (rs.next()) {
     // we have some dates with the same competition_id 
     // dates are grouped thanks to GROUP BY clause        
     if ( rs.getInt("id") != previousCompetitionId) {
       Competition currentCompetition = new Competition(rs.getInt("id"),
                     rs.getString("name");
       /* I prefer constructor initializers "o = new O(propertyValue)"
        instead of snippet "o = new O(); o.setProperty(value)"
       */
       result.add(currentCompetition);
       previousCompetitionId = currentCompetition.getid();
     } else {
       currentCompetition.addDate(new CompetitionInstance(rs.getString("date")));
     }
  }
  return result;
}
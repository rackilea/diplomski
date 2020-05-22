@Service
public class CommentJdbcService {
    public List<Comment> get(String commentId, Connection connection) throws Exception {
        PreparedStatement statement;
        ResultSet assetResult;
        try {
            String getSql = "SELECT * FROM comment WHERE comment_id=?::UUID";
            statement = connection.prepareStatement(getSql);
            statement.setString(1, commentId);
            List<Comment> comments = new ArrayList<>();
            assetResult = statement.executeQuery();
            while (assetResult.next()){
                comments.add(build(assetResult, connection));
            }
            return comments;
        } catch (Exception e) {
            // do exception handling
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch(SQLException se) {
                se.printStackTrace();
            }
            try {
                if (assetResult != null)
                    assetResult.close();
            } catch(SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
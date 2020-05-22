@ApiOperation(value = "Get a comment by ID")
@RequestMapping(value = "/{comment_id}", produces = "application/json", method = RequestMethod.GET)
public ResponseEntity getComment(@PathVariable String commentId) {
    List<Comment> result;
    Connection con;
    try {
        con = template.getDataSource().getConnection();
        result = commentJdbcService.get(comment_id, con);
    } catch (Exception e) {
        return log(e, HttpStatus.INTERNAL_SERVER_ERROR, slf4jLogger, Error.Levels.ERROR);
    } finally {
        try {
            if (con != null)
                con.close();
        } catch(SQLException se) {
            se.printStackTrace();
        }
    }
    return new ResponseEntity<>(result, HttpStatus.OK);
}
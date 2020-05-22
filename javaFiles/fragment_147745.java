public static Result deleteBar(String name) {

    SqlUpdate down = Ebean.createSqlUpdate("DELETE FROM bar WHERE name = :param1 ");
    down.setParameter("param1", name);
    int deletedCount = down.execute();

    return ok("Deleted " + deletedCount + " record(s)");
}
Database db = new Database();

    String sql = "CREATE TABLE IF NOT EXISTS `table` ("+
    "`key` INT(6) PRIMARY KEY,"+
    "`value` VARCHAR(50) NOT NULL"+
    ");";

    db.execute(sql);
    db.closeConnection();
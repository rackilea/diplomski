String querys = "insert into reconcile_process (process_type,fk_last_modified_by,fk_bank_stmt_id)"
                + " values (?,?,?)";

 Connection connections = sessionFactory.getCurrentSession().connection();
        PreparedStatement pstmts = connections.createStatement();
    pstmts.SetString("Auto");
    pstmts.SetInt(1);
    pstmts.setArray(3, conn.createArrayOf("integer", idArr));
        pstmts.executeUpdate(querys);
String updateQuery = 
        String.format(  "UPDATE \"user\" "
            +       "SET chips_balance=chips_balance + %d, diamonds_balance=diamonds_balance + %d "
            +       "WHERE id=%d "
            +       "RETURNING *", 100, 5, 64); 

User user = (User) session.createSQLQuery(updateQuery)
        .addEntity(User.class)
        .uniqueResult();
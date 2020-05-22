public boolean RetreiveId(UserBean userBean){
     boolean userExists = false;

/* Provide table name and column name carefully in the sql query below.
 * here i have a table "userbean" with two column's
 * "userId" and "password" both of varchar2 type.
 */
     String sql1 = "select userId from userbean "+"where userId = ?";
     UserBean ub = jdbcTemplate.queryForObject(sql1, 
              new Object[] { userBean.getUserId()});
     System.out.println("^^^^^^^^^^sql1"+sql1);

     if (ub != null) {
          userExists = true;
     }
     return userExists;
     }
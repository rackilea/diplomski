public List<OperatorDetailsBean> getOperators(String name) {
          PreparedStatement ps = null;
          List<OperatorDetailsBean> operatorList = new ArrayList();
          //Prahaladd - Setting this to null will cause operatorList to be null.
         // This is not being re-initalized anywhere else
          operatorList = null; 
          name = name.toUpperCase();
          String data;
          try {
              ps = connection.prepareStatement("SELECT * FROM operator_details_m  WHERE upper(name) LIKE ?");
              ps.setString(1, name + '%');
              ResultSet rs = ps.executeQuery();

              while (rs.next()) {
                  uname = rs.getString("NAME");
                  token = rs.getString("TOKEN_NO");
                  OperatorDetailsBean op = new OperatorDetailsBean();
                  op.setName(uname);
                  op.setTokenNo(token);
                  operatorList.add(op); //Prahaladd - definitely a NullPointerException
              }

          } catch (Exception e) {
              //Prahaladd - Oops!! NPE thrown above was gulped.
              //System.out.println(e.getMessage());
          }
          return operatorList; //returned operatorList is null. Will impact gson library processing
}
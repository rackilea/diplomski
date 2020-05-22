public List<Employee> getAllEmployees(){  
    return template.query("select * from employee",new ResultSetExtractor(){  
        @Override  
         public Object extractData(ResultSet rs) throws SQLException,  
            DataAccessException {  

            List<Employee> list=new ArrayList<Employee>();  
            while(rs.next()) {  
                Employee e=new Employee();  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setSalary(rs.getInt(3));  
                list.add(e);  
            }  
            return list;  
        }  
    });  
  }
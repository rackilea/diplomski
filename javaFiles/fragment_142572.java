while(rs.next()){
if(rs.getString(1)!=null && rs.getString(1).equals(props.getProperty("db.dbname")))
            {
                System.out.println("xxx");
            }
}
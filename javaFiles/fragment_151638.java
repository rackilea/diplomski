public class EmpBean {
                public java.util.List dataList(){
                    ArrayList list=new ArrayList();
                    try{
                         Class.forName("driver");
                               Connection con = DriverManager.getConnection("url", "user", "pwd");
                               Statement st=con.createStatement();
                               System.out.println("hiiiii");
                               ResultSet rs=st.executeQuery("select * from employee");
                               while(rs.next()){
                                   list.add(rs.getString("name"));
                                   list.add(rs.getString("address"));
                                   list.add(rs.getString("contactNo"));
                                   list.add(rs.getString("email"));


                    }
                               System.out.println(rs.getString("contactNo"));
                    }
                    catch(Exception e){}
                    return   list;

                    }

            }
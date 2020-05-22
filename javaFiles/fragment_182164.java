if ((rect != null) && (ell != null)) {
con.add(new Connection(rect,ell));
System.out.println("Size of ArrayList <Connection> is:" + con.size());                                   
                            SQL sql = new SQL();
                            sql.display(con);                                                                      
                        }
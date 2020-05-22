btnSubmit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) 
                    //frame.dispose();
                    JFrame2 f2=new JFrame2();
                    f2.setVisible(true);
                    f2.setLayout(null);
                try{
                    int x=154, width=89;
                    String query = "select name from decipline";
                    pst=conn.prepareStatement(query);
                    rs=pst.executeQuery();
                    //int i=0;
                while(rs.next())
                {   
                     String str= rs.getString("name");
                     JButton btn =new JButton(str);
                     System.out.println(str);
                     btn.addActionListener(new ActionListner(){
                          @Override
                    public void actionPerformed(ActionEvent e) {
                     .......
                       }
                     });
                     btn.setBounds(x, 112, width, 23);
                     x=x+width+1;
                     f2.getContentPane().add(btn);

                  }
                }
                catch(Exception E){
                    E.printStackTrace();
                } 
            }
        });
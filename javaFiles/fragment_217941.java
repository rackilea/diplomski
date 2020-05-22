JButton btnSearch = new JButton("Search");
    btnSearch.addActionListener(new ActionListener() 
    {
        public void actionPerformed(ActionEvent arg0) 
        {
            list.clear();
            String s  = SearchBox.getText();
            int i = 0,present = 0;
            int id;
            try
            {
                Class.forName(driver).newInstance();
                Connection conn = DriverManager.getConnection(url+dbName,userName,password);
                Statement st = conn.createStatement();
                ResultSet res = st.executeQuery("SELECT * FROM javaapp.test");
                while(res.next())
                {
                    i = 0;
                    present = 0;
                    while(i < 9)
                    {
                        String out = res.getString(search[i]);
                        if(out.toLowerCase().contains(s.toLowerCase()))
                        {
                            present = 1;
                            break;
                        }
                        i++;
                    }
                    if(tglbtnNormalshortlist.isSelected())
                    {
                        if(present == 1 && res.getInt("Shortlist") == 1)
                        {
                            id = res.getInt("Candidate");
                            String print = res.getString("Name");
                            list.addElement(print+" "+id);
                        }
                    }
                    else
                    {
                        if(present == 1 && res.getInt("Shortlist") == 0)
                        {
                            id = res.getInt("Candidate");
                            String print = res.getString("Name");
                            list.addElement(print+" "+id);
                        }
                    }
                }
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
    });
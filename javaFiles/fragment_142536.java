JPanel zusatzPanel = new JPanel();
zusatzPanel.setBounds(11, 291, 270, 113);
contentPane2.add(zusatzPanel);
zusatzPanel.setLayout(null);

JTextField[] containerinput; //like that
JComboBox[] containerselect; //like that
JLabel[] containerlabel;     //like that

int[] ZusatzpanelCase = new int [300];
ZusatzpanelCase[1] = 0;

comboBox_projekt.addActionListener (new ActionListener () {
    public void actionPerformed(ActionEvent e) {
        zusatzPanel.removeAll();    
        for(int key = 0; key < ObjektlängeForActionListener; key++){
            if(comboBox_projekt.getSelectedItem() == null){
                zusatzPanel.removeAll();    
                zusatzPanel.revalidate();
                zusatzPanel.repaint();
                break;
            }else{
                if(comboBox_projekt.getSelectedItem().equals(Projektname0JSON[key])){
                    zusatzPanel.removeAll();    
                    zusatzPanel.revalidate();
                    zusatzPanel.repaint();

                    String ZusatzString;
                    try {
                        ZusatzString = SimplePingPong.httpRequestZusatz(ProjektPK0JSON[key],"unused","zusatz");
                        if(ZusatzString.equals("Keine Werte")){
                            ZusatzpanelCase[1] = 0;

                        }else{  
                            JSONObject jsonObjectZusatz = new JSONObject(ZusatzString); 
                            int ZusatzJSONlength = jsonObjectZusatz.length();
                            int xValue = 0;
                            containerinput = new JTextField[ZusatzJSONlength];
                            containerselect = new JComboBox[ZusatzJSONlength];
                            containerlabel = new JLabel[ZusatzJSONlength];

                            for(int key1 = 0; key1 < ZusatzJSONlength; key1++){
                                JSONObject jsonObjectZusatzObjekt0 = jsonObjectZusatz.getJSONObject(String.valueOf(key1));  
                                String ZusatzNameJSON = jsonObjectZusatzObjekt0.getString("name");  // String auslesen!!!
                                String ZusatzTypJSON = jsonObjectZusatzObjekt0.getString("typ");  // String auslesen!!!
                                String ZusatzEintragJSON = jsonObjectZusatzObjekt0.getString("eintrag");  // String auslesen!!!

;


                                                    if(ZusatzTypJSON.equals("input")){
                                    containerinput[key1] = new JTextField();
                                    containerinput[key1].setBounds(108, xValue, 136, 20);
                                    zusatzPanel.add(containerinput[key1]);
                                    containerinput[key1].setColumns(10);
                                }
                                if(ZusatzTypJSON.equals("select")){
                                    containerselect[key1] = new JComboBox();
                                    containerselect[key1].setBounds(108, xValue, 136, 20);
                                    zusatzPanel.add(containerselect[key1]);
                                }
                                containerlabel[key1] = new JLabel(ZusatzNameJSON);
                                containerlabel[key1].setFont(new Font("Tahoma", Font.PLAIN, 15));
                                containerlabel[key1].setBounds(1, xValue + 1, 100, 15);
                                zusatzPanel.add(containerlabel[key1]);

                                ZusatzpanelCase[1] = 1;
                                ZusatzpanelCase[2] = ZusatzpanelCase[2] + 1;

                                xValue = xValue + 30;
                                zusatzPanel.revalidate();
                                zusatzPanel.repaint();
                            } 




                        }
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    } 



                }

            }
        }


    }
 });
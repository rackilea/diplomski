openButton.addActionListener(new ActionListener()
    {
    public void actionPerformed(ActionEvent e){
    JFileChooser openChooser = new JFileChooser();
    int openStatus = openChooser.showOpenDialog(null);
    if(openStatus == JFileChooser.APPROVE_OPTION){
        try{
            File myFile = openChooser.getSelectedFile();
            //BufferedReader br = new BufferedReader(new FileReader(myFile));
                             Scanner br = new Scanner(new FileReader(myFile));
            String line;        
        while((line = br.nextLine())!= null){
                        Object[] myRow = new Object[]{line,br.nextLine(), br.nextLine(), br.nextLine()};
                             model.addRow(myRow);
                            // line = br.readLine();
                                if(br.nextLine()== " "){
                                    line=br.nextLine();
                                }
                    }//end while
                      br.close();
                }//end try

                catch(Exception e2){
                     return;
                }//end catch
            }
        }

    });
class actionHandler implements ActionListener{
         public void actionPerformed(ActionEvent ev){
               if(ev.getActionCommand.equals("Done"))
                listForEdit.add(sbEdit);
                sbEdit = new StringBuilder();
               }
               else{
                    sbEdit.append(ev.getActionCommand());
                    }
              }
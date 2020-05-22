public void actionPerformed(ActionEvent e){
                    String a=comboBox.getSelectedItem().toString();
                    //Integer b=(comboBox_1.getSelectedIndex()+1);
                    int day=Integer.ParseInt(comboBox_2.getSelectedItem().toString());
                    double bo;
                    DecimalFormat df = new DecimalFormat("#.##");      
                    bo=  Double.parseDouble(df.format(day));
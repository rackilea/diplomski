JTextField firstName=new JTextField();
    JButton but=new JButton("Save");
    but.addActionListener(e1->{
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("asdf.txt"));
            bw.write(firstName.getText());
            bw.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    });
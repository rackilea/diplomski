ok.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){
            String t1 = txt1.getText();
            if(!"".equals(t1))
            tamanho = Double.parseDouble(t1);


            String t2 = txt2.getText();
            if(!"".equals(t2))
            peso = Double.parseDouble(t2);
              result = tamanho*tamanho;
            if (ok != null){
                System.out.println(result);
                System.out.println(peso);
                final JDesktopPane desk = new JDesktopPane();
                setContentPane(desk);
                JOptionPane.showInternalMessageDialog(desk,"Seu IMC é:"+ (result/ peso));
            }
        }
    });
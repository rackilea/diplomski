subTest.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                Converter convert = new Converter();
                convert.convertMe=Converter.this.convertMe;
                GridLayout converterGridLayout = new GridLayout(2,2,12,6);
                convert.setLayout(converterGridLayout);
                convert.setVisible(true);
            }
        });
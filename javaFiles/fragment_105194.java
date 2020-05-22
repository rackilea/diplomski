execute.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if(word.getText() != null){
                int res = Count.myMethod(word.getText());
                result.setText(String.valueOf(res));
            }
        }
    });
    add(execute);
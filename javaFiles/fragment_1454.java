answerBtn.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent arg0) {
                // Loop somewhere inside here

                String answerString = answerField.getText();

                try {
                    int answer = Integer.parseInt(answerString);
                } catch(NumberFormatException e){
                    error.setText("Number Cannot Be A Word");
                }
            }
        });
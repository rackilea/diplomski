addAnswerButtonMA.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
        answerFieldsMA.add(new JTextField());
        checkBoxesMA.add(new JCheckBox());
        multipleanswerPanel.add(answerFieldsMA.get(answerFieldsMA.size() - 1));
        multipleanswerPanel.add(checkBoxesMA.get(checkBoxesMA.size() - 1));

        multipleanswerPanel.revalidate();
        validate();
        pack()
        }
    });
showDetailsButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent arg0)
        {
            Student selectedStudent = (Student) jCombo.getSelectedItem();
            new StudentDetails(selectedStudent.getId());

        }
    });
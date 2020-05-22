for(int rowCounter = 1; rowCounter <= rowCount; rowCounter++) {
    for(int colCounter = 1; colCounter <= colCount; colCounter++){
        final JButton j = new JButton(Integer.toString(rowCounter * colCounter));
        j.addActionListener(new MultiplerActionListener(countLabel, rowCounter, colCounter));
        buttonPanel.add(j); 
    }
}
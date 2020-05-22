for (int i = 0; i < arrayBtn.length; i++) {
    arrayBtn[i] = new JButton();
    arrayBtn[i].setBackground(Color.WHITE);
    arrayBtn[i].setSize(1, 1);

    // This works (set every button text to "9"):
    arrayBtn[i].setText("9");

    // This will NOT work:
    arrayBtn[1].setText("9"); 

    frame.add(arrayBtn[i]);
}

// This works (set the first button text to "9"):
arrayBtn[0].setText("9");
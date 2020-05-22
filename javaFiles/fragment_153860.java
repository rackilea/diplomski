int count = 0;
public void actionPerformed(ActionEvent ae) {
    Date date = new Date();
    String dateText = sdf.format(date);
    if (count % 2 == 0) {
        dateText = dateText.replace(":", " ");
        setText(dateText);
    }
    setText(dateText);
    count++;
}
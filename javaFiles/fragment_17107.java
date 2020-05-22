JLabel label = new JLabel();
gui.add(label);
while (a == 1){         
    String timeStamp = new SimpleDateFormat("hh:mm:ss a").format(Calendar.getInstance().getTime()); 
    label.setText(String.valueOf(timeStamp));
    timeStamp = "";
    label.revalidate();
}
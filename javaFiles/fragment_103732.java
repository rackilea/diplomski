public void itemStateChanged(ItemEvent event) {
  // Object source = event.getSource();
  int price1 = 0;
  int price2 = 0;
  // if(source == cbox1){
  int roomIndex = cbox1.getSelectedIndex();
  if (roomIndex == 0) {
     price1 = 600;
  } else if (roomIndex == 1) {
     price1 = 800;
  } else if (roomIndex == 2) {
     price1 = 1000;
  }
  // }
  // if(source == cbox2){
  int activityIndex = cbox2.getSelectedIndex();
  if (activityIndex == 0) {
     price2 = 60;
  } else if (activityIndex == 1) {
     price2 = 40;
  } else if (activityIndex == 2) {
     price2 = 50;
  }
  // }
  label2.setText("Rental Amount Due: $" + (price1 + price2));
}
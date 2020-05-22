String str = "";

Random rand = new Random();

for(int i=0; i<7; i++){
    str += (rand.nextInt(49) + 1) + " ";
}

txtTextBox.setText(str);
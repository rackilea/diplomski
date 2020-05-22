switch (v.getId()) {
case R.id.back:
    position--;
    if(position<0) { position=25; }
    // mainButton.setText(alphabet[position]);
    // mainButton.setBackgroundColor(Color.rgb(randomColor, randomColor2, randomColor3));

    break;
case R.id.forward:
    position++;
    if(position>25) { position=0; }
    // mainButton.setText(alphabet[position]);
    // mainButton.setBackgroundColor(Color.rgb(randomColor, randomColor2, randomColor3));

    break;
}
// for better improvement this can be added once for both cases
mainButton.setText(alphabet[position]);
mainButton.setBackgroundColor(Color.rgb(randomColor, randomColor2, randomColor3));
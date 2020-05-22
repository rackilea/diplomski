int result = 0;
result += (byte)(spinner1.getSelectedItemPosition() << 16);
result += (byte)(spinner2.getSelectedItemPosition() << 8);
result += (byte)(spinner3.getSelectedItemPosition());

switch(result) {
case 0x000000: //All spinners 0
case 0x010201: //S1 = 1, S2 = 2, S3 = 1
    //Do something
    break;
case 0x010101: //S1 = 1, S2 = 1, S3 = 1
    //Do something else
    break;
default:
    //Everything else (good if most of your options go to the same Activity)
}
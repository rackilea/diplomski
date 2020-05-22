StringBuilder sb = new StringBuilder();
for (int i=0; i < mTypeSelection.length; i++){
    if(mTypeSelection[i] > -1) {
        sb.append(Character.forDigit(mTypeSelection[i], 10));
    } else {
        break;
    }
}
String result = sb.toString();
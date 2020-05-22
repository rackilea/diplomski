String check = String.valueOf(dataList.getItemAtPosition(position));
int pos = check.indexOf(".");
int pos2 = check.indexOf(" ");
String strP = check.substring(pos2+1, pos);
int pos3 = Integer.valueOf(strP) - 1;

switch(position) {
    case 0:
    Log.i("pos", String.valueOf(pos));
    Log.i("pos2", String.valueOf(pos2));
    Log.i("strP", strP);
    Log.i("check", check);
    moveToActivity(String.valueOf(pos3)); //0
    break;
    case 1:
        moveToActivity(String.valueOf(pos3)); //1
        break;
    case 2:
        moveToActivity(String.valueOf(pos3)); //2
        break;
    case 3:
        moveToActivity(String.valueOf(pos3)); //3
        break;
}
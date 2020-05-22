double[] doubleList = new double[2];
doubleList[1] = 1221312312;
doubleList[2] = 1231231231;

List<Integer> intList = new ArrayList<>();
intList.add(1);
intList.add(2);

List<String> stringList = new ArrayList<>();
stringList.add("2");
stringList.add("3");

final String doubleSeparateCommaString =
  android.text.TextUtils.join(",", new double[][] { doubleList });

final String intSeparatedCommaString = android.text.TextUtils.join(",", intList);

final String stringSeparatedCommaString =  android.text.TextUtils.join(",", stringList);
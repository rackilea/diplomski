String maleName = null;
String femaleName = null;
for (int i = 0; i < 10; i++) {

    if ('M' == oneName.get(i).getSex()) {

        maleName = oneName.get(i).getName();

    }
    if ('F' == oneName.get(i).getSex()) {

        femaleName = oneName.get(i).getName();

    }

    if (maleName != null && femaleName != null) {

        System.out.printf("%13.10s%10.10s%n", femaleName, maleName);
        maleName = null;
        femaleName = null;

    }
}
public static void main(String[] args) {
    String[][][][] troopStats = new String[4][4][4][4];
    int times = 2;
    int weaponTimes = 3;
    String weaponTimesStr = Integer.toString(weaponTimes);
    System.out.println(weaponTimesStr + "string"); //prints 3string
    troopStats[times][1][0][1] = weaponTimesStr;
    System.out.println(troopStats[times][1][0][1] + "InArray"); //prints 3InArray
}
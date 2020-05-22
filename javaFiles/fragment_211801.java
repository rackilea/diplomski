static boolean find;
static boolean[] flag;

public static void findNumber(List<Integer> list, int sumNumber, int targetNumber) {
    if (sumNumber == targetNumber) {
        System.out.println("Find Number");
        find = true;
        return;
    }

    for (int i = 0; i < list.size(); i++) {
        if (flag[i] == false && list.get(i) + sumNumber <= targetNumber) {
            flag[i] = true;
            findNumber(list, sumNumber + list.get(i), targetNumber);
            if (find)
                return;
            flag[i] = false;
        }
    }
}

public static void main(String[] args) {
    List<Integer> positiveList = new ArrayList<Integer>();
    List<Integer> negativeList = new ArrayList<Integer>();

    for (int i = 0; i < negativeList.size(); i++) {
        flag = new boolean[positiveList.size()];
        find = false;
        findNumber(positiveList, 0, negativeList.get(i));

        if (find) {
            negativeList.set(i, 0);
            for (int j = 0; j < positiveList.size(); j++) {
                if (flag[j])
                    positiveList.set(j, 0);
            }
        }
    }

    System.out.println("PositiveList: " + positiveList);
    System.out.println("NegativeList: " + negativeList);

}
private int index = 0;
private int[] tabAnswer = new int[4];

public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(jbr)) {
        tabAnswer[index] = 0;
    } else if (e.getSource().equals(jbv)) {
        tabAnswer[index] = 1;
    } else if (e.getSource().equals(jbj)) {
        tabAnswer[index] = 2;
    } else if (e.getSource().equals(jbb)) {
        tabAnswer[index] = 3;
    } else if (e.getSource().equals(jbo)) {
        tabAnswer[index] = 4;
    } else if (e.getSource().equals(jbn)) {
        tabAnswer[index] = 5;
    }
    index++;
    if (index >= tabAnswer.length) {
        System.out.println(Arrays.toString(tabAnswer));
        index = 0;
    }
}
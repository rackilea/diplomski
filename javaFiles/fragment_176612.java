public  void main(String var1, String var2) {

    String[] arrayA = var1.split("\\.");

    String[] arrayB = var2.split("\\.");
    int length = 0;
    if (arrayA.length > arrayB.length) {
        length = arrayA.length;
    } else {
        length = arrayB.length;
    }
    int check = 0;
    for (int i = 0; i < length; i++) {
        Integer number1 = 0, number2 = 0;
        if (arrayA.length > i) {
            number1 = Integer.parseInt(arrayA[i]);
        }
        if (arrayB.length > i) {
            number2 = Integer.parseInt(arrayB[i]);
        }
        if (number1.equals(number2)) {
            check = 0;
        } else if (number1 > number2) {
            check = 1;
            break;

        } else if (number2 > number1) {
            check = 2;
            break;
        }
    }
    switch (check) {
    case 0:
        System.out.println("arrays equal");
        break;
    case 1:
        System.out.println("array A newer version");
        break;
    case 2:
        System.out.println("array B newer version");
        break;
    }

}
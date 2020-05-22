public void mysort() {
    Random randomNumbers = new Random();

    int randomArray[] = new int[20];

    for (int j = 0; j < randomArray.length; j++) {
        randomArray[j] = randomNumbers.nextInt(200) + 1;
    }

    for (int i = 0; i < randomArray.length; i++) {
        for (int k = 1; k < randomArray.length; k++) {
            if (randomArray[k - 1] < randomArray[k]) {
                int hjelp = randomArray[k - 1];
                randomArray[k - 1] = randomArray[k];
                randomArray[k] = hjelp;
            }
        }
    }

    for (int i = 0; i < randomArray.length; i++) {
        System.out.println(randomArray[i]);
    }
}
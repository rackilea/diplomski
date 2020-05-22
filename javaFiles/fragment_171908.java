Random rand = new Random(); //random number generator
    Integer[] rand_number = new int[4]; //this array take 4 diferent number
    int count = 0;
    try {
        while (count < 4) {
            random_number = rand.nextInt(4) + 1;
            int n = 0;
            for (int i = 0; i < rand_number.length(); i++) {
                if (random_number != rand_number[i]) {
                    n++;
                }
            }
            if (n == rand_number.length()) {
                rand_number[rand_number.length()] = random_number;
                count++;
            }
        }

    } catch (Exception e) {
         Toast.makeText(getBaseContext(), e.toString(), Toast.LENGTH_LONG)
         .show();
    } // now ypu get 4 random number it will be 0, 2, 3, 1 or 2, 0, 1, 3 or ...

    //your random answers
    String var1 = answers[rand_number[0];
    String var2 = answers[rand_number[1];
    String var3 = answers[rand_number[2];
    String var4 = answers[rand_number[3];
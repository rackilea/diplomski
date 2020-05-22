public static void users() {

        String[] names = new String[5];
        int[] ages = new int[5];


        for (int i = 0; i < names.length; i++) {

            String a = JOptionPane.showInputDialog(null, "What's your name, user " + (i+1) + "?");
            int b = Integer.parseInt(JOptionPane.showInputDialog(null, "What is your age, " + a + "?"));

            names[i] = a;
            ages[i] = b;

        }

        double agecount = 0;

        for (int i = 0; i < names.length; i++) {
            agecount += ages[i];
            System.out.println("User " + (i+1) + ":  " + names[i] + " " + ages[i] + " years old");
        }
        double avarageAge = agecount /names.length;

        System.out.println("The avarage age for this quiz is " + avarageAge);

    }
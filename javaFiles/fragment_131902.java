Scanner sc = new Scanner(System.in);

    for (int i = 0;;i++){
        System.out.println("Donnez un nombre plus grand que 0 ou 0 pour terminer");
        int note = sc.nextInt();
        int reversed = 0;

        do {
            int digits = note % 10;
            reversed = reversed * 10 + digits;
            note = note/10;
        }
        while (note > 0); {
            System.out.println("Les numeros a l'envers est " + reversed);
        }
    }
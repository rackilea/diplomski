Scanner sc = new Scanner (new File("c:/Users/ASUS/Desktop/Numbers.txt"));
            int str = sc.nextInt();
            while (sc.hasNextInt() && str != 6){
                System.out.print(str+ " ");
                str = sc.nextInt();
            }       
            sc.close();
        }
    }
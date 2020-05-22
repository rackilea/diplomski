Scanner A = new Scanner(System.in);
        System.out.println("Person A Enter Year");
        int B = A.nextInt();
        System.out.println("Enter Month");
        int C = A.nextInt();
        System.out.println("Enter Day");
        int Z = A.nextInt();

        System.out.println("Person B Enter Year");
        int D = A.nextInt();
        System.out.println("Enter Month");
        int E = A.nextInt();
        System.out.println("Enter Day");
        int F = A.nextInt();

        if (B < D) {
            System.out.println("Person A is older");
        } else if (B == D) {
            if (C < E) {
                System.out.println("Person A is older");
            } else if (B == D && C == E) {
                if (Z < F) {
                    System.out.println("Person A is older");
                } else if(B == D && C == E && Z == F) {
                    System.out.println("They are same");
                } else {
                    System.out.println("Person A is younger");
                }
            } else {
                System.out.println("Person A is younger");
            }
        } else {
            System.out.println("Person A is younger");
        }
String stringToSplit = "-0.06409677515180673  0.12516724483856012  -0.06188844693840026  0.1542289929525214  -0.06603595481351604  0.07823062287735344  0.10161817634744892  $ -0.33597610014929263";

        String[] splitArrayPhaseA = stringToSplit.split("\\$");
        String part1 = splitArrayPhaseA[0];
        String part2 = splitArrayPhaseA[1];

        /*
         * Part 1
         */
        String[] innersplitpart1 = part1.split("  ");

        String[][] omegastr = new String[innersplitpart1.length][];
        int omegar = 0;
        for (String omegakeyrow : innersplitpart1) {
            omegastr[omegar++] = omegakeyrow.split("  ");
        }

        String[] innersplitpart2 = part2.split("  ");

        String[][] gamastr = new String[innersplitpart2.length][];
        int gamar = 0;
        for (String gamakeyrow : innersplitpart2) {
            gamastr[gamar++] = gamakeyrow.split("  ");
        }
        /*
         * part1 and part2 to double
         */

        double[][] A = new double[omegastr.length][omegastr[0].length];
        double[][] B = new double[gamastr.length][gamastr[0].length];

        for(int vali =0;vali< omegastr.length ;vali ++){
               for(int valj = 0;valj <omegastr[0].length;valj++){
                  A[vali][valj] = Double.parseDouble(omegastr[vali][valj]);
               }

           }
        for(int valgi =0;valgi< gamastr.length ;valgi ++){
               for(int valgj = 0;valgj <gamastr[0].length;valgj++){
                   B[valgi][valgj] = Double.parseDouble(gamastr[valgi][valgj]);
               }

           }
        System.out.println(omegastr.length+":"+omegastr[0].length);
        System.out.println("Part 1");
       for(int vali =0;vali< A.length ;vali ++){
           for(int valj = 0;valj <A[0].length;valj++){
               System.out.print(A[vali][valj]+ "\t");
           }
           System.out.println(""); 
       }
       System.out.println();
       System.out.println("Part 2");
       for(int vali =0;vali< B.length ;vali ++){
           for(int valj = 0;valj <B[0].length;valj++){
               System.out.print(B[vali][valj]+ "\t");
           }
           System.out.println("");
       }
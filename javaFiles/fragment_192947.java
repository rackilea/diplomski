if (userAnswer.equals(compAnswer)) {
            System.out.println("Huh. A tie. That was... disappointing.");
            win = 2;
        } else if ("rock".equals(compAnswer)) {
            {
                if ("paper".equals(userAnswer)) {
                    System.out.println("Curses! I threw rock and lost!");
                    win = 0;
                } else if ("scissors".equals(userAnswer)) {
                    System.out.println("Hah! I threw rock and crushed your scissors!");
                    win = 1;
                }
            }
        } else {
            System.out.println("...You cheater! That's not a legal throw! Off to the fire and brimstone with you!");
        }
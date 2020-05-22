int rnd1, rnd2;

                List<Integer> list = new ArrayList<Integer>();              

                if (!((Answer)bOdgovor1.getTag()).isCorrect) {
                    list.add(1);
                }
                if (!((Answer)bOdgovor2.getTag()).isCorrect) {
                    list.add(2);
                }
                if (!((Answer)bOdgovor3.getTag()).isCorrect) {
                    list.add(3);
                }
                if (!((Answer)bOdgovor4.getTag()).isCorrect) {
                    list.add(4);
                }   
                Collections.shuffle(list);
                rnd1 = list.get(0);
                rnd2 = list.get(1);

                if ((rnd1 == 1) || (rnd2 == 1)){
                    bOdgovor1.setText("");
                }
                if ((rnd1 == 2) || (rnd2 == 2)){
                    bOdgovor2.setText("");
                }
                if ((rnd1 == 3) || (rnd2 == 3)){
                    bOdgovor3.setText("");
                }
                if ((rnd1 == 4) || (rnd2 == 4)){
                    bOdgovor4.setText("");
                }
            }
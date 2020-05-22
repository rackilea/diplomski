for (int i = 0; i < sparseSeg.size(); i++) {
                String[] hs = sparseSeg.valueAt(i).split("/");
                int idDoLL = sparseSeg.keyAt(i);
                if ((inicio && !hs[1].equals("vazio") && intercede(hs[0], hs[1], time, time2)) ||
                        (!inicio && !hs[1].equals("vazio") && intercede(time, time2, hs[0], hs[1]))) {
                    if (inicio) { // DO SOMETHING
                    } else {
                        // SHOULD ALWAYS END HERE //
                        listIntercedeOut.add(4);
                        listIntercedeOut.add(idDoLL);

                        Log.i("1 CONDITION", i + "");
              // IF WE RELEASE THIS FOR, EVERYTHING WORKS FINE

                                /*for(i = 1; i < listIntercedeOut.size(); i++) {
                                }*/
                    }
                } else if (inicio && listIntercedeIn.contains(4) && listIntercedeIn.contains(0)) {
                    listIntercedeIn.remove(Integer.valueOf(4));
                    listIntercedeIn.remove(Integer.valueOf(idDoLL));

                    Log.i("2 CONDITION", i + "");

                } else if (!inicio && listIntercedeOut.contains(4) && listIntercedeOut.contains(0)) {

     // IF WE DISABLE THE FOLLOWING 2 LINES, EVERYTHING WORKS FINE

                    listIntercedeOut.remove(Integer.valueOf(4));
                    listIntercedeOut.remove(Integer.valueOf(0));

                    Log.i("3 CONDITION", i + "");
                }
            }
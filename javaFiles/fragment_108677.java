if (sCurrentLine.startsWith("5")){

                    count1++;
                    bw.write(sCurrentLine);
                    bw.newLine();
                    five = sCurrentLine;





                }else if (sCurrentLine.startsWith("6") && count2 == 0){

                    count2++;
                    bw.write(sCurrentLine);
                    bw.newLine();

                }else if (sCurrentLine.startsWith("8")){

                    count3++;
                    bw.write(sCurrentLine);
                    bw.newLine();
                    eight = sCurrentLine;

                }else if(sCurrentLine.startsWith("6") && count2 ==1){

                    bw.write(five);
                    bw.write(sCurrentLine);
                    bw.write(eight);
                }
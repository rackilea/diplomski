while(text.hasNextLine()){
           String currentLine = text.nextLine();
           String nextLine = "";
           if(text.hasNextLine())[
               nextLine  = text.nextLine();
           }

           /**ACC conditions*/
           if((currentLine.matches(fp100)||currentLine.matches(fp200)
                || currentLine.matches(fp300)) 
                && (nextLine.matches(fp100)|| nextLine.matches(fp101) 
                     || nextLine.matches(fp200)
                     || nextLine.matches(fp201) || nextLine.matches(fp300)
                     || nextLine.matches(fp301)) {
                                //current line is OK
                                System.out.println(currentLine);
                                output.write(currentLine);
                                output.write("\n");
                                abc1List.add(currentLine);
                                lineOK++;               

                                //next line is OK
                                System.out.println(nextLine);
                                output.write(nextLine);
                                output.write("\n");
                                abc1List.add(nextLine);
                                // <-- not sure if you want OK as 1 or 2 here 
                                lineOK++;           
           } /**REJ conditions*/
           else if(!currentLine.matches(fp100)||!currentLine.matches(fp101)||
                  !currentLine.matches(fp200)||!currentLine.matches(fp201)||
                  !currentLine.matches(fp300)||!currentLine.matches(fp301)){   
                        System.out.println("invalid cfg; terminating....");
                   System.exit(0);
           }
       }//end of while
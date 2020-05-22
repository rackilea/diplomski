line = new StringBuilder();
                 boolean ready = false;
                 int c = 0;
                        Thread.sleep(1000);//needs to sleep, it isnt ready :(
                        while((ready = consoleOutput.ready()) == true){
                            ready = consoleOutput.ready();
                            c = consoleOutput.read();//read char by char
                            line.append((char)c);
                            if((char)c == ':' && (c=consoleOutput.read()) == 0x20 && (consoleOutput.ready()!= true)){
                                pin.write((command + "\n\r").getBytes());//writing after ready
                                pin.flush();
                                System.out.println(line.toString() + command);
                                line = null;
                                break;
                            }
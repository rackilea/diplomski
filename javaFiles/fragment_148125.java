String[] commands =  new String[5];
                  commands[0] = "cmd";
                  commands[1] = "/c";
                  commands[2] = "C:\\Program Files\\AVG\\AVG10\\avgscanx.exe";
                  commands[3] = "/scan=" + filename;
                  commands[4] = "/report=" + virusoutput;


                 Runtime rt = Runtime.getRuntime();
                 Process proc = rt.exec(commands);
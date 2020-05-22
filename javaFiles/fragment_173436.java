if(! data.isEmpty()){                     // rather than: data != ""
            System.out.println("[IN] " + data);
        }
        ...
        if(ex[1].equals("001")){                  // rather than: ex[1] == "001"
            writeout("JOIN #minecraft");
        }
        ...
        if(ex[0].equals("PING")){                 // rather than: ex[0] == "PING"
            writeout("PONG " + ex[1]);
        }
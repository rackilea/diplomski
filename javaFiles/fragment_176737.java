case CONNECTED:
        try {
           // Send data
           if (toSend.length() != 0) {
              out.print(toSend); out.flush();
              toSend.setLength(0);
              changeStatusTS(NULL, true);
           }

           // Receive data
           if (in.ready()) {
              s = in.readLine();
              if ((s != null) &&  (s.length() != 0)) {
                 // Check if it is the end of a trasmission
                 if (s.equals(END_CHAT_SESSION)) {
                    changeStatusTS(DISCONNECTING, true);
                 }

                 // Otherwise, receive what text
                 else {
                    appendToChatBox("INCOMING: " + s + "\n");
                    changeStatusTS(NULL, true);
                 }
              }
           }
        }
        catch (IOException e) {
           cleanUp();
           changeStatusTS(DISCONNECTED, false);
        }
        break;
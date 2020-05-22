while (clientIntMessage != ProtocolASCII.EOT) {
                    clientIntMessage = inFromClient.read();
                    currentMsg += String.valueOf(Character.toChars(clientIntMessage));
                    // System.out.println(currentMsg);
                    if (clientIntMessage == ProtocolASCII.ENQ) {
                        outToClient.writeBytes("" + ProtocolASCII.ACK);
                        System.out.println("[ACK] on Analyzer [ENQ]");
                    } else if (clientIntMessage == ProtocolASCII.ACK) {                        
                        System.out.println("Analyzer [ACK]");
                        // Send your order message here
                         outToClient.writeBytes(retmsg);
                        }
                    } else if (clientIntMessage == ProtocolASCII.LF) {
                        outToClient.writeBytes("" + ProtocolASCII.ACK);
                    } else if (clientIntMessage == ProtocolASCII.NAK) {
                        System.out.println(" Analyzer sent [NAK] ");
                    }

                }
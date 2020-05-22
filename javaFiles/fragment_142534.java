while((bytesLeidos = socket.getInputStream().read(buff, 0, buff.length)) > -1) {

            System.out.println("Bytes leidos: " + bytesLeidos);

            if ((bytesLeidos == 70) && (Protocolo.isStatusMessage(buff))) {
                Protocolo.decode(buff, salida);
            } else {


                int offset = 0;

                // Code changed
                while (offset < bytesLeidos) {

                    if (Protocolo.isStatusMessageWithOffset(buff, offset)) {
                        // decodificar
                        Protocolo.decodeWithOffset(buff, offset, salida);
                        offset += 70;
                    } else {
                        offset++;
                    }
                }
                // End code changed
            }
        }
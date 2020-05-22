if (noOfSector > 32) {
                //CHUNK DATA
                int maxLength = 16384;
                int lengthReceivedData = 0;
                int remaining;
                int chunkSize = (noOfSector + 32 - 1) / 32;int first= chuckSize;
                byte[] receivedData = new byte[maxLength];
                while (chunkSize > 1) {
                    cswBuffer = new byte[maxLength];
                    iRes = conn.bulkTransfer(epIN, cswBuffer, maxLength, 500);

                    if (chunkSize == first) {//if first time do this
                        receivedData = cswBuffer;
                    } else {

                        receivedData = concatenateByteArrays(receivedData, cswBuffer);
                    }

                    chunkSize--;
                    lengthReceivedData += maxLength;
                }
                remaining = sectorLength - lengthReceivedData;
                if (chunkSize == 1) {//last one sector
                    cswBuffer = new byte[remaining];
                    iRes = conn.bulkTransfer(epIN, cswBuffer, remaining, 500);
                    receivedData = concatenateByteArrays(receivedData, cswBuffer);
                    finalBuffer = receivedData;
                }
                //END CHUNK DATA
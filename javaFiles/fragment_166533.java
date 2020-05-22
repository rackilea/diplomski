StringBuffer stringBuffer = new StringBuffer();
                String line = "";
                BufferedReader bufferReader = new BufferedReader(
                                       new InputStreamReader(request.getInputStream()));
                while ((line = bufferReader.readLine()) != null) {         
                    stringBuffer.append(line);
                }
                notificationString = stringBuffer.toString();
is = incoming.getInputStream(); // initiating inputStream
            os = incoming.getOutputStream(); // initiating outputStream

            in = new BufferedReader(new InputStreamReader(is)); // initiating
                                                                // bufferReader
            out = new DataOutputStream(os); // initiating DataOutputSteream

            RequestHandler rh = new RequestHandler(); // create a
                                                        // requestHandler
                                                        // object

            String line;
            while ((line = in.readLine()) != null) {
                if (line.equals("")) { // last line of request message
                                        // header is a
                                        // blank line (\r\n\r\n)
                    break; // quit while loop when last line of header is
                            // reached
                }

                // checking line if it has information about Content-Length
                // weather it has message body or not
                if (line.startsWith("Content-Length: ")) { // get the
                                                            // content-length
                    int index = line.indexOf(':') + 1;
                    String len = line.substring(index).trim();
                    length = Integer.parseInt(len);
                }

                request.append(line + "\n"); // append the request
            } // end of while to read headers

            // if there is Message body, go in to this loop
            if (length > 0) {
                int read;
                while ((read = in.read()) != -1) {
                    body.append((char) read);
                    if (body.length() == length)
                        break;
                }
            }

            request.append(body); // adding the body to request
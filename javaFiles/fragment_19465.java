long charsRead = 0;

                while(keepRunning)
                {
                    URL url = new URL(finalUrlString);
                    URLConnection connection = url.openConnection();
                    InputStreamReader stream = new InputStreamReader(connection.getInputStream());
                    BufferedReader reader = new BufferedReader(stream);
                    long skipped = reader.skip(charsRead);
                    String line = reader.readLine();
                    if(line != null)
                    {
                        charsRead += line.length() + 1;
                        process(line);
                    }
                    reader.close();
                }
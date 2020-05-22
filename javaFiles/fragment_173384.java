while (scanner.hasNextLine()) {

                    String line = scanner.nextLine();
                    byte[] utf8 = line.getBytes("UTF-8");
                    line = new String(utf8, "UTF-8");

                    bw.write(line);
                    System.out.println(line);
                }
                // close the buffered
                bw.close();
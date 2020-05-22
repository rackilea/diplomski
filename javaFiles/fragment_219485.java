while ( readIn.hasNext() )
            {               

                String line = readIn.nextLine();
                String str[] = line.split(",");

                for (int i = 0; i < str.length ; i++)
                {
                    String k = str[0];
                    int v = Integer.parseInt(str[1]);
                    h.put(k , v);
                }

                System.out.println(h.toString());

            }
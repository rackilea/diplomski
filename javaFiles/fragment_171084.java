// Wrong: List<String> list = new ArrayList<String>();
                    list = new ArrayList<String>(); //
                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                        list.add(line);
                    }
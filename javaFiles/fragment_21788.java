Date expiry = null;
SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");

                try {
                     String dt;
                     if(!(dt=str.nextToken()).equals("null")){
                    expiry = formatter.parse(dt);
                    System.out.println(expiry);
                    System.out.println(formatter.format(expiry));
                     }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
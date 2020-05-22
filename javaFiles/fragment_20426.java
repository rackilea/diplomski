char[] utf8 = null;
            StringBuilder properString = new StringBuilder("");

            utf8 = Response.toCharArray();

            for (int i = 0; i < utf8.length; i++) {
                if ((int) utf8[i] < 65000) {
                    properString.append(utf8[i]);
                }
            }
  System.out.println("Response of Login::"
                        + properString.toString());
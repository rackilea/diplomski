public static void checkIndex() {
            File file = new File("path");
            BufferedReader reader = null;
            StringBuffer buffer = new StringBuffer();
            String strReading = "";
            try {
                reader = new BufferedReader(new FileReader(file));
                while ((strReading = reader.readLine()) != null) {
                    buffer.append(strReading);
                }
                int index = buffer.toString().lastIndexOf(" ") + 1;
                System.out.println(buffer.substring(index));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
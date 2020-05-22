try {
            String fileid = filename + "." + extension;

            File file = new File(fileid);
            @SuppressWarnings("resource")
            PrintWriter writer = new PrintWriter(new FileWriter(file));

            for (int i = 0; i < data.length; i++) {
                writer.println(data[i]);
            }
        }
        catch (IOException writeFail) {}
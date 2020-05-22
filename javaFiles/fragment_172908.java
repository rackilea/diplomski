try {

        br = new BufferedReader(new FileReader(filePath));
        while ((line = br.readLine()) != null) {

            // code here to handle the current readed line

        }

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
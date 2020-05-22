while ((line = file.readLine()) != null) {
        ArrayList<String> arr2= new ArrayList<String>();
        String[] words = line.split("\\,");
        for (int ae = 0; ae < words.length; ae++) {
            arr2.add(words[ae]);
        }
        arr1.add(arr2);

    }
    file.close();
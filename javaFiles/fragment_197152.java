ArrayList<String> arrayList = new ArrayList<String>();
        String field = "ah3w 38 45 1";

        arrayList.add("zj4e 32   4  45");
        arrayList.add("ah3w       38  45   1");
        arrayList.add("ab2 56 2 45");

        //solution
        String fieldNoWhitespaces = field.replaceAll("\\s", "");

        for (String dataElement : arrayList) {
            String arg = dataElement.replaceAll("\\s", "");
            if (fieldNoWhitespaces.equals(arg)) arrayList.remove(dataElement);      
        }

        //just to check for correctness
        for (String dataElement : arrayList) {
            System.out.println(":::" + dataElement);

            int count = 0;
            for (int i = 0; i < dataElement.length(); i++) {
                if (Character.isWhitespace(dataElement.charAt(i))) {
                    count++;
                }
            }

        System.out.println(":::Whitespaces:::" + count);
    }
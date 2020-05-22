String s = strLine;
    List<String> myList = Arrays.asList(s.split(" "));
    List<Integer> intList = new ArrayList<>();
        for (int i=0;i<myList.size();i++) {
            //Check if all the values are integers
            try {

               /*Problem area----->*/ intList.add(Integer.parseInt( (String) myList.get(i)));

            } catch (Exception e) {
                throw new FormatException();
            }
        }
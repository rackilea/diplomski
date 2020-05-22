List<Integer> buttonNumbers = new ArrayList<Integer>();
    for (int i = 0; i < but.length; i++){
        for (String s : characters){
            if (but.getText().contains(s) && !buttonNumbers.contains(i)){
                buttonNumbers.add(i);
            }
        }
    }
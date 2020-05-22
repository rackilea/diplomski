for (int i = 0 ; i != input1.size() ; i++)
    for (int j = 0 ; j != input2.size() ; j++)
        for (int k = 0 ; k != input3.size() ; k++) {
            String[] data = new String[] {
                input1.get(i), input2.get(j), input3.get(k)
            };
            Process(data);
        }
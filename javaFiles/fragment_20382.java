int j = 0;
    int count = 1;
    for (int i = 0; i < costs.size(); ++i){
        if (count  % cities.size() != 0 && j < cities.size()){
            twoDArrayList.get(j).add(costs.get(i));
            ++count;
        }
        else {
            count = 2;
            ++j;
            if (j < cities.size()) twoDArrayList.get(j).add(costs.get(i));
        }
    }

    System.out.println(twoDArrayList);
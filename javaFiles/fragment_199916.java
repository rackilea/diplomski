else {
      int minLength=0;
      List<Integer> minConfig=new ArrayList<Integer>();
      for (int coin : coins) {
        List<Integer> results = minCoins(lenChoices, value - coin, maxdenomination);
        if (!results.isEmpty()) {
          if (minLength==0 || (1+results.size()) < minConfig.size()) {               
            results.add(coin);
            minConfig=results;
            minLength=minConfig.size();
          }
          break; // If we already have a result we don't need to look for the rest of the coins!
        }
      }    
      lenChoices.put(value, minConfig);  
      return lenChoices.get(value);
    }
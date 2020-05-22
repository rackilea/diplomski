public  List<Integer> Mincoins() {
    Map<Integer, List<Integer>> lenChoices=new HashMap<Integer, List<Integer>>();
    Collections.sort(coins, Collections.reverseOrder()); // since later on in the code you are iterating over your coins, it makes sense to sort them with the largest first so that you are slowly left with the bits that can not be divided by the larger values and have more probability to be caught be the small ones
    int maxdenomination=Collections.max(coins);
    Integer sum1= new Integer(sum);
    List<Integer> result = new ArrayList<Integer>();
    for (Integer c: coins) { //as per  Nishant Shreshth's comment, you need to check all invalid coins first and don't bother unless one which produces results is found
      println(c);
      result = minCoins(lenChoices, sum, c, 0);
      lenChoices.clear();
      if (result.size() > 0) break;
    }
    return result;
  }
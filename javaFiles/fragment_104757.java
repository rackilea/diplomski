Hashtable<String, Double> balance = new Hashtable<String, Double>();

      balance.put("Zara", new Double(3434.34));
      balance.put("Mahnaz", new Double(123.22));
      balance.put("Ayan", new Double(1378.00));
      balance.put("Daisy", new Double(99.22));
      balance.put("Qadir", new Double(-19.08));

      System.out.println(balance);
      Double d = 99.22;



     String key=null;
        for(Map.Entry entry: balance.entrySet()){
          if(d.equals(entry.getValue())){
              key = (String) entry.getKey();
              break;
          }
      }
      System.out.println("got key from value in hashtable key:  "+ key +" value: " + d);
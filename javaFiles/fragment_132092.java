String input = "Laxman";            
            HashMap<String, String> street = new HashMap<String, String>();
            street.put("1", "Sachin Tendulkar");
            street.put("2", "Dravid");
            street.put("3", "Sehwag");
            street.put("4", "Laxman");         

            for (Map.Entry<String, String> entry : street.entrySet()) { 
                System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
                if (input.equals(entry.getKey())) {
                    System.out.println(entry.getValue());   
                    break;
                } else if (input.equals(entry.getValue())) {
                    System.out.println(entry.getKey());   
                    break;
                }               
            }
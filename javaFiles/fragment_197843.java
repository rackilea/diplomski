if(inputStr1 == null || inputStr2 == null){
            return null;
        }

        String res = "";

        HashMap<Character, Integer> hm = new HashMap<>(); 

        for(int i = 0; i < inputStr2.length(); i++){
            Character c = inputStr2.charAt(i);
            if(hm.containsKey(c)){
                hm.put(c, hm.get(c) + 1);
            } else{
                hm.put(c, 1);
            }
        }

        for(int i = 0; i < inputStr1.length(); i++){
            Character ch = inputStr1.charAt(i);
            if(hm.containsKey(ch)){
                res += ch;
                int c = hm.get(ch);
                if (c - 1 > 0){
                    hm.put(ch, c - 1);
                } else{
                    hm.remove(ch);
                }
            }
        }

        if(res.length() > 0){
            return res;
        }

        return null;
    }
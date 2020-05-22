List<String> wins = Arrays.asList(new String[]{"Won", "Won", "Won", "Loss", "Loss", "Won", "Won", "Loss", "Loss", "Loss", "Loss", "Loss", "Won", "Won", "Won", "Won", "Won", "Loss"});
        System.out.println(wins);
        String value = wins.get(0);
        int maxValue=1;
        int count = 1 ;
        for(int i=1;i<wins.size();i++){
            if(wins.get(i) == wins.get(i-1)){
                count++;
                if(count >= maxValue){
                    maxValue = count;
                    value = wins.get(i);
                }
            }else{
                count=1;
            }
        }
        System.out.println(value + " : " + maxValue );
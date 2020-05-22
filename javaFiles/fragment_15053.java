public static  Integer temp1;
    public static  Map<Integer,ArrayList<String>> temp2 = new HashMap<>();     
final Map< Integer,ArrayList<String>> deger = new HashMap<>();
            deger.put(1,new ArrayList<>(Arrays.asList("h:1","g:1","s:0")));
            deger.put(2,new ArrayList<>(Arrays.asList("h:1","g:1","g:0")));
            deger.put(3,new ArrayList<>(Arrays.asList("h:1","c:0","g:0")));
            deger.put(4,new ArrayList<>(Arrays.asList("h:1","s:1","g:0")));


            Pattern<String,?> pattern = Pattern.<String>begin("start").where(
                    new SimpleCondition<String>() {
                        @Override
                        public boolean filter(String value) throws Exception {
                            flag = false;
                            for(Map.Entry<Integer, ArrayList<String>> entryStart : deger.entrySet()) {
                                if(entryStart.getValue().contains(value) && !temp2.containsKey(entryStart.getKey())){
                                        ArrayList<String> newList = new ArrayList<String>();
                                        newList.addAll(entryStart.getValue());
                                        newList.remove(value);
                                        temp2.put(entryStart.getKey(),newList);
                                        flag = true;
                                }
                            }
                            return flag;
                        }
                    }
            ).followedBy("middle").where(
                    new SimpleCondition<String>() {
                        @Override
                        public boolean filter(String middle) throws Exception {
                            flag = false;
                            for(Map.Entry<Integer, ArrayList<String>> entryMiddle : temp2.entrySet()) {
                                if(entryMiddle.getValue().contains(middle) && entryMiddle.getValue().size() == 2){
                                    ArrayList<String> newListMiddle = new ArrayList<String>();
                                    newListMiddle.addAll(entryMiddle.getValue());
                                    newListMiddle.remove(middle);
                                    temp2.put(entryMiddle.getKey(),newListMiddle);
                                    flag = true;
                                }
                            }
                            return flag;
                        }
                    }
            ).followedBy("end").where(
                    new SimpleCondition<String>() {
                        @Override
                        public boolean filter(String end) throws Exception {
                            flag = false;
                            for(Map.Entry<Integer, ArrayList<String>> entryEnd : temp2.entrySet()) {
                                if(entryEnd.getValue().contains(end) && entryEnd.getValue().size() == 1){
                                    flag = true;
                                    temp1 = entryEnd.getKey();
                                }
                            }
                            if (flag)
                                temp2.remove(temp1);
                            return flag;
                        }
                    }
            );

            PatternStream<String> patternStream = CEP.pattern(stream_itemset_ham,pattern);

            DataStream<String> result = patternStream.select(
                    new PatternSelectFunction<String, String>() {
                        @Override
                        public String select(Map<String, List<String>> map) throws Exception {
                            ArrayList<String> NewList= new ArrayList<>();
                            NewList.addAll(deger.get(temp1));
                            String found = "Found";
                            for (String list_element : NewList)
                                found += " " + list_element ;
                            return found;
                        }
                    }
            );
            result.print();
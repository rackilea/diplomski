for(int i=0;i<n;i++){
            int x=sc.nextInt();
            Integer value = map.get(x);
            if(x < k){
                if(value == null) {
                    map.put(x, 1);
                }
                else if(value<=1) map.put(x,2);
            }
        }
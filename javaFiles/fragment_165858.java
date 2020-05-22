if(it.hasNext()){
            Object id=it.next();
            int val=(Integer) map.get(id);
            int finalval;
            if(val>score)
            {
                finalval= val-score;
                map.put(id, finalval);
            }
            else
            {
                val=(Integer) map.get(id);
                map.put(id, "0");
                id=it.next();
                val+=(Integer) map.get(id);
                if(val>score)
                {
                    finalval=val-score;
                    map.put(id, finalval);
                }
                else
                {
                    map.put(id, "0");
                    id=it.next();
                    val+=(Integer) map.get(id);
                    System.out.println(id);
                    if(val>=score)
                    {
                        finalval=val-score;
                        map.put(id, finalval);
                    }
                }

            }
            System.out.println(map);
        }
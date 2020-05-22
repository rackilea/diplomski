for(Object objArray : args) { 
                if(objArray == null) continue;
                    Object[] ob = (Object[])objArray ;
                    for(Object eachObject : ob) { 
                        System.out.println("eachObject reference = " + eachObject);
                    }
            }
List<String[]> data = new ArrayList<String[]>();
        List<String> tmp= new ArrayList<String>();
         for(int m = 0; m < hugeList.size(); m++) {
                  String[] values = hugeList.get(m);
                  tmp.add(values[4]);       
           }
         data.add(tmp.toArray(new String[0]));
        }
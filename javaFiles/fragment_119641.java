Collections.sort(mylist, new Comparator<String[]>() {  
            public int compare(String[] o1, String[] o2) {  
                if(o1[1].equals(o2[1]){  
                   return -(o1[0].compareTo(o2[0]));
                }  

                int one= Integer.parseInt(o1[1]);
                int two = Integer.parseInt(o2[1]);
                return one-two;
            }
        });
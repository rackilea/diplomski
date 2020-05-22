Collections.sort(Mycollect,new Comparator<PLClass>(){
        @Override
       public int compare(PLClass o1, PLClass o2) {
          Double i = o1.PL;
          Double j = o2.PL;
          return i.compareTo(j);
       };  
    };
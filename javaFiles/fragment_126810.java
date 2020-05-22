Collections.sort(taskdet, new Comparator<Fullist>() {

        @Override
        public int compare(fullist o1, fullist o2) {                
            int res = Integer.compare(o1.date, o2.date);
            if(res == 0)
                return o1.id - o2.id
            return res;
        }
    });
@Override
        public int compare(String[] o1, String[] o2) {
            int cmp = 0;

            if(o1[0].equals(o2[0])){//grouping 1st column
                for(int i=1;i<o1.length;i++){
                    cmp = (o1[i]).compareTo(o2[i]);
                    if(cmp==0)
                        return cmp;// if two column matched return immediately
                }
            } else {
                return o1[0].compareTo(o2[0]);
            }

            return cmp;
        }
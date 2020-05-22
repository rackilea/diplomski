ArrayList<Integer> clist = new ArrayList<Integer>();
        StringTokenizer st = new StringTokenizer(list);

        while(st.hasMoreTokens()){
            String id = st.nextToken(",");
            clist.add(Integer.parseInt(id));
        }
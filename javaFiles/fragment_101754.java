class MyAdapter {

     private HashMap<Integer, Integer> processedPositions = new HashMap<Integer, Integer>();

     @Override
     public View getView(int position, View convertView, ViewGroup parent) {
            if (!processedPositions.containsKey(position)) {  // < ------------------
                   first time logic......
                   processedPositions.put(position, position); // and mark as processed
            else {
                   later times logic....
            }
     }
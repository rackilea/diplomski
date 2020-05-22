Table table = new Table(){
    final Long hexcode = new java.util.Random().nextLong();
        @Override 
        public String toString(){
            return hexcode.toString();
        }
    };
    System.out.println("table: " + table);
LinkedList<String> paths = new LinkedList<String>() {
        public boolean addAll(Collection<? extends String> c) {
            System.out.println("In overiden addAll");
            if(c != null) {
                return super.addAll(c);
            }
            return false;
        }
    };
    // This now works
    paths.addAll(null);
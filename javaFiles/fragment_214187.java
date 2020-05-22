public static<T> void passObjType(T e) {
             ArrayList<T> arr = new ArrayList<T>();
        }

        public static void main(String[] args) {
            HashSet<String> hs = new HashSet<String>();
            String hp = new String();
            passObjType(hs);
            passObjType(hp);
        }
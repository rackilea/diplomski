public class YourSingleton  {  

        private static YourSingleton mInstance;
        private ArrayList<String> list = null;

        public static YourSingleton getInstance() {
            if(mInstance == null)
                mInstance = new YourSingleton();

            return mInstance;
        }

        private YourSingleton() {
          list = new ArrayList<String>();
        }
        // retrieve array from anywhere
        public ArrayList<String> getArray() {
         return this.list;
        }
        //Add element to array
        public void addToArray(String value) {
         list.add(value);
        }
}
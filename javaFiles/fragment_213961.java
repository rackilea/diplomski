public class CustomClass{
        //Bind it to a string just for example
        private HashMap<String, ImageView> mMap = new HashMap<String, ImageView>();
        public CustomClass(ArrayList<ImageView> ivArray) {
            for (ImageView iView : ivArray) {
                mMap.put("SomeValue", iView);
            }
        }
        public ImageView getImageViewByString(String s){
            return mMap.get(s);
        }
    }
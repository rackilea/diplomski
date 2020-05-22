public class Factory {

        public static class JavaApiImpl implements JavaAPI{

                public JustSomeAPISpecificType clone(){
                        return JustSomeAPISpecificType.INSTANCE;
                }
        }

        public static JavaAPI getAPI(){
                return new JavaApiImpl();
        }
}
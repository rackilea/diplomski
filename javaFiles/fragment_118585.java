class Merger{

        public static String merge(Nour n, Stack s) {
                return "[" + getArrContent(n.sayHelloJSON()) + "," +
                                getArrContent(s.sayHelloJSON()) + "]";
        }
        private static String getArrContent(String str) {
                return str.replace("[", "").replace("]", "");
        }
}
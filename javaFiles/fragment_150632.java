public static void main(String[] args) throws Exception {
    new Object() {
        @Override
        protected void finalize() throws Throwable {
            System.out.println("GC");
        }
    };
}
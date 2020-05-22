public class OBJConversion {

    public static void main(String[] args) {

        Gson gson = new GsonBuilder()
                // NOTE: all Lists will be treated as List<A>
                .registerTypeAdapter(List.class, new ACollectionAdapter())
                .create();

        // Line 1
        List<A> aList = gson.fromJson("[1,2,3,4]", List.class));
        // Line 2
        System.out.println("main().aList : " + aList);
        // Line 3
        System.out.println("main().someString : " + aList.get(0).getSomeString());
    }

    static class ACollectionAdapter extends TypeAdapter<List<A>> {

        @Override
        public void write(
                JsonWriter out, List<A> value) throws IOException {
            out.beginArray();
            for (A a : value) {
                out.value(a.getSomeString());
            }
            out.endArray();
        }

        @Override
        public List<A> read(JsonReader in) throws IOException {
            List<A> as = new ArrayList<A>();
            in.beginArray();
            while (in.hasNext()) {
                A a = new A();
                a.setSomeString(in.nextString());
                as.add(a);
            }
            in.endArray();
            return as;
        }
    }

    static class A {

        String someString = null;

        public String getSomeString() {
            return someString;
        }

        public void setSomeString(String someString) {
            this.someString = someString;
        }
    }
}
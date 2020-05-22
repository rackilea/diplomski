public enum Something {
    a,
    b,
    c;

    public static class Bound implements QueryStringBindable<Bound>{
       private Something value;

        @Override
        public F.Option<ClientStatus> bind(String key, Map<String, String[]> params) {
            String[] arr = params.get(key);
            if (arr != null && arr.lenght > 0) {
                this.value = Something.valueOf(arr[0]);
                return F.Option.Some(this);
            } else {
                return F.Option.None();
            }
        }

        @Override
        public String unbind(String key) {
            return this.value.name();
        }

        @Override
       public String javascriptUnbind() {
            return this.value.name();
       }

       public Something value(){
           return this.value;
       }
    }
}
public class B {

        @JsonProperty("bProp")
        public String getBProp() {
            return "bProp";
        }


    @JsonUnwrapped
        public A getA() {
            return new A();
        }
}
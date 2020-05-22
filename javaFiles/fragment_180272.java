public enum MyKeyEnum {
    VALUE1 {
        public void decode(InputParameters ip) {
            // do specific decoding for VALUE1
        }
    },
    VALUE2 {
        public void decode(InputParameters ip) {
            // do specific decoding for VALUE2
        }
    }
    ...
    ;

    public abstract void decode(InputParameters ip);
}
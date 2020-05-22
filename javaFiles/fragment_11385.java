public static SwitchInputType<?> switchInput(InputType type) {
    switch(type){
        BINARY:
            return new SwitchInputType<Byte>(new Byte("23ABFF"));
        DECIMAL:
            return new SwitchInputType<BigDecimal>(new BigDecimal("A"));
        BOOLEAN:
            return new SwitchInputType<Boolean>(new Boolean("true"));
    }
}
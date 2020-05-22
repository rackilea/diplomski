private TransformerStrategy createTransformerStrategyWithABCValues(Param1 param1, Param2 param2, IVar ivar, IVar1 ivar2) {
    return new TransformerStrategy() {
        public FooRequest transform(FooResponse response) {
            return FooRequestTransformer.transform(
                    param1,
                    param2,
                    iVar1,
                    iVar2);
        }
    };
}
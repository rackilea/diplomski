public interface InnerPatternSelectFunction<T> extends PatternSelectFunction<String, T>, ResultTypeQueryable<T>{};

public DataStream<T> applyPatternSelectToStream(DataStream<String> stream, IEventPattern<String, T> pattern) {
    TypeInformation<T> producedType = this.typeInformation;
    return CEP.pattern(stream, pattern.getEventPattern()).select(new InnerPatternSelectFunction<T>() {
        @Override
        public TypeInformation<T> getProducedType() {
            return producedType;
        }

        @Override
        public T select(Map<String, List<String>> map) throws Exception {
            return pattern.create(map);
        }
    });
}
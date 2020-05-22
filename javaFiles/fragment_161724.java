// Add it somewhere in this file.
private static final Set <Characteristics> CH_ID = Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.IDENTITY_FINISH));

//...
// This is main processing code
processes.stream().collect(collectingAndThen(groupingBy(Process::getDate, new Collector<Process, Result, Result> {
            @Override
            public Supplier<Result> supplier() {
                return Result::new;
            }

            @Override
            public BiConsumer<Process, Result> accumlator() {
                return (p, r) -> {
                    r.total++;
                    if (p.isHasError())
                        r.error++;
                };
            }

            @Override
            public BinaryOperator<Result> combiner() {
                return (r1, r2) -> {
                    r1.total += r2.total;
                    r1.error += r2.error;
                    return r1;
                };
            }

            @Override
            public Function<Result, Result> finisher() {
                return Function.identity();
            }

            @Override
            public Set<Characteristics> characteristics() {
                return CH_ID;
            }
})));
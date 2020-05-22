Stream stream1 = fishList.stream();
    // Collection#stream():
    Spliterator spliterator = fishList.spliterator();
        return Spliterators.spliterator(fishList.a, 0);
            return new ArraySpliterator(fishList, 0);
    return StreamSupport.stream(spliterator, false)
        return new ReferencePipeline.Head(spliterator, StreamOpFlag.fromCharacteristics(spliterator), false)
Predicate fishPredicate = /* new lambda f -> f.contains("fish") */
Stream stream2 = stream1.filter(fishPredicate);
    return new StatelessOp(this, StreamShape.REFERENCE, StreamOpFlag.NOT_SIZED) { /* ... */ }
Function fishFunction = /* new lambda f.substring(0, 1).toUpperCase() + f.substring(1) */
Stream stream3 = stream2.map(fishFunction);
    return new StatelessOp(this, StreamShape.REFERENCE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { /* ... */ }
Collector collector = Collectors.toList();
    Supplier supplier = /* new lambda */
    BiConsumer accumulator = /* new lambda */
    BinaryOperator combiner = /* new lambda */
    return new CollectorImpl<>(supplier, accumulator, combiner, CH_ID);
List hasFishList = stream3.collect(collector)
    // ReferencePipeline#StatelessOp#collect(Collector):
    List container;
    if (stream3.isParallel() && /* not executed */) { /* not executed */ }
    else {
    /*>*/TerminalOp terminalOp = ReduceOps.makeRef(collector)
            Supplier supplier = Objects.requireNonNull(collector).supplier();
            BiConsumer accumulator = collector.accumulator();
            BinaryOperator combiner = collector.combiner();
            return new ReduceOp(StreamShape.REFERENCE) { /* ... */ }
    /*>*/container = stream3.evaluate(terminalOp);
            // AbstractPipeline#evaluate(TerminalOp):
            if (linkedOrConsumed) { /* not executed */ }
            linkedOrConsumed = true;
            if (isParallel()) { /* not executed */ }
            else {
            /*>*/Spliterator spliterator2 = sourceSpliterator(terminalOp.getOpFlags())
                    // AbstractPipeline#sourceSpliterator(int):
                    if (sourceStage.sourceSpliterator != null) { /* not executed */ }
                    /* ... */
                    if (isParallel()) { /* not executed */ }
                    return spliterator;
            /*>*/terminalOp.evaluateSequential(stream3, spliterator2);
                    // ReduceOps#ReduceOp#evaluateSequential(PipelineHelper, Spliterator):
                    ReducingSink sink = terminalOp.makeSink()
                        return new ReducingSink()
                    Sink sink = terminalOp.wrapAndCopyInto(sink, spliterator)
                        Sink wrappedSink = wrapSink(sink)
                            // AbstractPipeline#wrapSink(Sink)
                            for (/* executed twice */) { p.opWrapSink(p.previousStage.combinedFlags, sink) }
                                return new Sink.ChainedReference(sink)
                        terminalOp.copyInto(wrappedSink, spliterator);
                            // AbstractPipeline#copyInto()
                            if (!StreamOpFlag.SHORT_CIRCUIT.isKnown(getStreamAndOpFlags())) {
                            /*>*/wrappedSink.begin(spliterator.getExactSizeIfKnown());
                            /*>*/ /* not important */
                            /*>*/supplier.get() // initializes ArrayList
                            /*>*/spliterator.forEachRemaining(wrappedSink)
                                    // Spliterators#ArraySpliterator#foreachRemaining(Consumer):
                                    // ... unimportant code
!!                                  do {
                                    /*>*/action.accept((String)a[i])
                                    } while (++i < hi) // for each fish :)
                            /*>*/wrappedSink.end() // no-op
                            } else { /* not executed */}
                        return sink;
                    return sink.get()
            }
    /*>*/if (collector.characteristics().contains(Collector.Characteristics.IDENTITY_FINISH)) { return container; }
    /*>*/else { /* not executed */ }
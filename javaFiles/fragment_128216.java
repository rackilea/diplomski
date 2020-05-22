----- Fast case -----
java.util.stream.ReduceOps$ReduceOp::evaluateSequential(Ljava/util/stream/PipelineHelper;Ljava/util/Spliterator;)Ljava/lang/Object;
  interpreter_invocation_count:    13382 
  invocation_counter:              13382 
  backedge_counter:                    0 
  mdo size: 552 bytes

0 aload_1
1 fast_aload_0
2 invokevirtual 3 <java/util/stream/ReduceOps$ReduceOp.makeSink()Ljava/util/stream/ReduceOps$AccumulatingSink;> 
  0   bci: 2    VirtualCallData     count(0) entries(1)
                                    'java/util/stream/ReduceOps$8'(12870 1.00)
5 aload_2
6 invokevirtual 4 <java/util/stream/PipelineHelper.wrapAndCopyInto(Ljava/util/stream/Sink;Ljava/util/Spliterator;)Ljava/util/stream/Sink;> 
  48  bci: 6    VirtualCallData     count(0) entries(1)
                                    'java/util/stream/ReferencePipeline$5'(12870 1.00)
9 checkcast 5 <java/util/stream/ReduceOps$AccumulatingSink>
  96  bci: 9    ReceiverTypeData    count(0) entries(1)
                                    'java/util/stream/ReduceOps$8ReducingSink'(12870 1.00)
12 invokeinterface 6 <java/util/stream/ReduceOps$AccumulatingSink.get()Ljava/lang/Object;> 
  144 bci: 12   VirtualCallData     count(0) entries(1)
                                    'java/util/stream/ReduceOps$8ReducingSink'(12870 1.00)
17 areturn

----- Slow case -----
java.util.stream.ReduceOps$ReduceOp::evaluateSequential(Ljava/util/stream/PipelineHelper;Ljava/util/Spliterator;)Ljava/lang/Object;
  interpreter_invocation_count:    54751 
  invocation_counter:              54751 
  backedge_counter:                    0 
  mdo size: 552 bytes

0 aload_1
1 fast_aload_0
2 invokevirtual 3 <java/util/stream/ReduceOps$ReduceOp.makeSink()Ljava/util/stream/ReduceOps$AccumulatingSink;> 
  0   bci: 2    VirtualCallData     count(0) entries(2)
                                    'java/util/stream/ReduceOps$2'(16 0.00)
                                    'java/util/stream/ReduceOps$8'(54223 1.00)
5 aload_2
6 invokevirtual 4 <java/util/stream/PipelineHelper.wrapAndCopyInto(Ljava/util/stream/Sink;Ljava/util/Spliterator;)Ljava/util/stream/Sink;> 
  48  bci: 6    VirtualCallData     count(0) entries(2)
                                    'java/util/stream/ReferencePipeline$Head'(16 0.00)
                                    'java/util/stream/ReferencePipeline$5'(54223 1.00)
9 checkcast 5 <java/util/stream/ReduceOps$AccumulatingSink>
  96  bci: 9    ReceiverTypeData    count(0) entries(2)
                                    'java/util/stream/ReduceOps$2ReducingSink'(16 0.00)
                                    'java/util/stream/ReduceOps$8ReducingSink'(54228 1.00)
12 invokeinterface 6 <java/util/stream/ReduceOps$AccumulatingSink.get()Ljava/lang/Object;> 
  144 bci: 12   VirtualCallData     count(0) entries(2)
                                    'java/util/stream/ReduceOps$2ReducingSink'(16 0.00)
                                    'java/util/stream/ReduceOps$8ReducingSink'(54228 1.00)
17 areturn
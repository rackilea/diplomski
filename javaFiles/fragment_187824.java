public static <U, D> FlowableTransformer<U, D> singleMultipleBranching(
    FlowableTransformer<U, D> singleBranchTransformer,
    FlowableTransformer<U, D> manyBranchTransformer
)
{
    return
        fl ->
            fl.replay( //replay so that you get connectableFlowable inside
                       f -> f.buffer(2)
                             .take(1)
                             .switchMap(
                                 buf -> {
                                     switch (buf.size()) {
                                     case 1:
                                         return f.compose(
                                             singleBranchTransformer);
                                     case 2:
                                         return f.compose(
                                             manyBranchTransformer);
                                     default:
                                         return Flowable.empty();
                                     }
                                 }
                             )
            );

}
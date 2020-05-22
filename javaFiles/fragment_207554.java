if (!catboost.CalcModelPrediction(
                modelHandle,
                new size_t(2L),
                ppFloatFeatures, new size_t((long)floatFeatures.length),
                ppCatFeatures, new size_t((long)catFeatures.length),
                pResult, new size_t(2L)
                ))
{
    throw new RuntimeException("No prediction made: " + catboost.GetErrorString());
}
public interface CatboostModel extends Library {
        public boolean LoadFullModelFromFile(Pointer calcer, String filename);
        public boolean CalcModelPrediction(Pointer calcer, size_t docCount,
                Pointer[] floatFeatures, size_t floatFeaturesSize,
                Pointer[] catFeatures, size_t catFeaturesSize,
                Pointer result, size_t resultSize);
    }
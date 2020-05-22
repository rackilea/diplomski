DoccatModel model;
if(model_file.exists()) {
    model = new DoccatModel(model_file);
} else {
    model = trainedModel(trainingDatasetPath);
    serializeModel(model);
}
DocumentCategorizer doccat = new DocumentCategorizerME(model);
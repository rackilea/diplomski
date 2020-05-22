EasyPredictModelWrapper model = new EasyPredictModelWrapper(
            new EasyPredictModelWrapper.Config()
                .setModel(MojoModel.load(MODEL_CLASS_NAME))
                .setConvertUnknownCategoricalLevelsToNa(true)
                .setConvertInvalidNumbersToNa(true)
        );
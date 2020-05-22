private Function<IOMessage<String>, IOMessage<List<Polygon>>> parseShapesInput = (
            input) -> {
        if (input instanceof IOMessage.Success) {
            return parseSuccessfulShapesInput
                    .apply(((IOMessage.Success<String>) input).payload);
        }
        if (input instanceof IOMessage.Error) {
            return new IOMessage.Error<>(((IOMessage.Error<String>) input).t);
        }
        return new IOMessage.Quit<>();
    };
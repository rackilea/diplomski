BinaryOperator<String> combinerNeverBeCalledInSequentiallyStream=(identity,t) -> {
   throw new IllegalStateException("Can't be used in parallel stream");
};

String result = variables.entrySet().stream()
            .reduce(templateText
                   , (it, var) -> it.replaceAll(format("\\$\\{%s\\}", var.getKey())
                                               , var.getValue())
                   , combinerNeverBeCalledInSequentiallyStream);
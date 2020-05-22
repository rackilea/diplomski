BiConsumer<_notaFiscalServicoGeraServicosMov, Double> consumer = (instance, param) -> {
    try {
        methodInstance.invoke(instance, new Object[] {param});
    } catch (LotsOfExceptionsHere e) {
        throw new RuntimeException(e);
    }
};
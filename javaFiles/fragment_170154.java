public static <I, O> void transform(Converter<I, O> converter, List inputList) {
        Iterator<I> it = inputList.iterator();
        List list = new LinkedList<>();
        while (it.hasNext()) {
            list.add(converter.retriever(it.next()));
        }
        converter.tranformer(list);
    }
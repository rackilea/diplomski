class MyConverter<T> {
    //               V takes a thing (in our case a DTO)
    //                       V returns a list of Strings
    private Function<T, List<String>> f;

    public MyConverter(Function<T, List<String>> f) {
          this.f = f;
    }

    public void process(T processable) {
         List<String> list = f.apply(processable);
    }
}

MyConverter<DTO> converter = new MyConverter<>(DTO::getList);

DTO dto = new DTO();
converter.process(dto);
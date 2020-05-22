@Bean
BiFunction<String, String, FileProcess> createFileProcess(MyDAO dao) {
    return (c1, c2) -> {
        FileProcess result = new FileProcess(dao) ;
        result.setConfig1(c1);
        result.setConfig2(c2);
        return result;
   };
}
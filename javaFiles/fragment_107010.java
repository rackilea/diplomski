public MyPojoSuper getMyPojo() {
    restTemplate.setErrorHandler(new MyCustomResponseErrorHandler());

    try {
        return restTemplate.getForObject(getURLWithParams(), MyPojo.class);
    } catch (RestErrorExeption e) {
        log.info(e.getMessage());
        return e.getRestError();
    }
}
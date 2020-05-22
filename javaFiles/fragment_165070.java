list.stream()
    .map(bean -> manager.find(bean.getID()))
    .filter(bean ->  bean.getApi() != null)
    .forEach(bean -> {
        //TODO
     });
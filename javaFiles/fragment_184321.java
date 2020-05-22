public JsonResponseDataModel selectOneAuto(Long id, CompanyRepository repository, HttpServletResponse response){

    final JsonResponseDataModel result = new JsonResponseDataModel();
    System.out.println("The name of class is " + repository.getClass().getName());

    Method[] methods = repository.getClass().getMethods();
    for (Method method : methods) {
    System.out.println("Method: " + method.getName());
    }

    try {
    //Method method = repository.getClass().getMethod("selectOne", Long.class);
    Method method = repository.getClass().getDeclaredMethod("selectOne", Long.class);
    method.invoke(repository, id);

    logger.info("selectOneAuto : id={} ", id);
    } catch (EmptyResultDataAccessException e) {
    result.setEmptyResultDataAccessException("id", id.toString());
    } catch (DataAccessException e) {            
    e.printStackTrace();            
    } catch (NoSuchMethodException e) {            
    e.printStackTrace();            
    } catch (IllegalAccessException e) {            
    e.printStackTrace();            
    } catch (InvocationTargetException e) {            
    e.printStackTrace();            
    }
    return result;
}
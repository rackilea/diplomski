ClassPool defaultClassPool = ClassPool.getDefault();
 CtClass superInterface = defaultClassPool.getCtClass(CrudRepository.class
            .getName());
 CtClass catRepositoryInterface = defaultClassPool.makeInterface("CatRepository", ctClass);

// something is missing here :-(

 catRepositoryInterface.toClass()
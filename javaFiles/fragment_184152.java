class BaseModel { }

class ModelA extends BaseModel { }

class ModelB extends BaseModel { }

interface Service { }

class ServiceImplementation<T extends BaseModel> implements Service { }

class ServiceFactory {
    public static Service getService(ModelA model) { return new ServiceImplementation<ModelA>(); }
    public static Service getService(ModelB model) { return new ServiceImplementation<ModelB>(); }
    public static Service getService(BaseModel model) { 
        throw new UnsupportedOperationException("Unknown Service Model");
    }
}

class Handler<T extends BaseModel> {
    private Service service;

    Handler(T model) {
        service = ServiceFactory.getService(model);
    }
}
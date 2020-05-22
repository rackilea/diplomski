public abstract class AbstractControl<T extends IService> {

    private T service;

    protected T getService(){
        return service;
    }

    public void setService(T service) {
        this.service = service;
    }
  }
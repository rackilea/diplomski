public abstract class Callback<T> implements Serializable{
    private static final long serialVersionID = ...; //version Id goes here
    private Class<T> data_class;

    public Callback(Class<T> data_class){this.data_class = data_class;}
    public abstract void onSuccess(T insertedData){}
    public abstract void onFailure(T failedData, CustomException ex){}

    public final void onSuccessFromJson(String json){
        Gson gson = new GsonBuilder().create();
        T entity = gson.fromJson(json,data_class);
        onSuccess(entity);
    }
    public final void onFailureFromJson(String json, CustonException ex){
        Gson gson = new GsonBuilder().create();
        T entity = gson.fromJson(json,data_class);
        onFailure(entity,ex);    
    }    
}
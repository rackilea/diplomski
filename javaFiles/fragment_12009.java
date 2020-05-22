public interface IAdapterItem{
    //Whatever functionality is needed
}

public class MyCustomAdapter<T extends IAdapterItem> extends ArrayAdapter<T>{
    //Adapter implementation
}
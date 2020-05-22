public interface Observer
{
    public void handleSomeEvent(Object someObjectOfImportance);
}

public class Observable
{
    public void register(Observer observer);
}
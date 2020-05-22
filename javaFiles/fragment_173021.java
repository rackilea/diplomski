public class Orchestrator<K>
{
    private INotifier<Object, K> notifier;

    public K getOrchestratedNotifications() {
        return notifier.getNotifications();
    }
}
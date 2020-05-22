public interface EventListener<T extends Data> {
    T modify(T data);
}

public interface ServerInfoEventListener extends EventListener<ServerInfoData> {
    @Override ServerInfoData modify(ServerInfoData data);
}
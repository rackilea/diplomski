@HotReload(type = HotReloadType.SYNC)
@LoadPolicy(LoadType.MERGE)
@Sources("file:${config.filepath}/config.properties")
public interface Configuration extends Config, Reloadable, Mutable, Accessible {

    @Key("server.http.port")
    int port();

    @Key("server.host.name")
    String hostname();

}
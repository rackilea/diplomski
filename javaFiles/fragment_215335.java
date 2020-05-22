public class Api {
  public static void main(String... args) throws Exception {
    RatpackServer.start(serverSpec -> serverSpec
      .serverConfig(serverConfigBuilder -> serverConfigBuilder
        .env()
        .build()
      )
      .registry(
        Guice.registry(bindingsSpec -> bindingsSpec
          .bind(ServerErrorHandler.class, ErrorHandler.class)
        )
      )
      .handlers(chain -> chain
        .all(ratpack.handling.RequestLogger.ncsa())
        .all(Context::notFound)
      )
    );
  }
}
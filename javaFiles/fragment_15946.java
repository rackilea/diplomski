@Getter
@RequiredArgsConstructor
public class CacheControlMaxAge {
  private final int maxAge;
}

@Component
public class CacheControlMaxAgeConverter implements Converter<HttpRequest, CacheControlMaxAge> {

  public CacheControlMaxAge convert(HttpRequest request) {
    // todo: extract stuff from request
    return new CacheControlMaxAge(...);
  }
}

public Response blah(..., CacheControlMaxAge cacheControl) { ... }
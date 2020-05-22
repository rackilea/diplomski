@RequiredArgsConstructor
@Slf4j
public class OAuthTokenInterceptor implements ClientHttpRequestInterceptor {
  private final TokenService tokenService;

  @NotNull
  @Override
  public ClientHttpResponse intercept(HttpRequest request, byte[] body,
                                      ClientHttpRequestExecution execution) throws IOException {
    request.getHeaders().add("Authorization", "Bearer " + tokenService.getRefreshedToken().getValue());
    return execution.execute(request, body);
  }
}
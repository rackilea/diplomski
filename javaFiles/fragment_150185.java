@Component
public class AddJwtFilter implements GlobalFilter {
    return webClient.get()
             .uri("https://localhost:9001/security/generatejwt/{accessToken}", 
                  accessToken)
             .retrieve()
             .bodyToMono(String.class).flatMap(response -> {
                 System.out.println(response);
                 return chain.filter(exchange);
             });
}
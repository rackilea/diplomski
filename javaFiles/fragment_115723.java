package be.smartask.service.suggestions;


import be.smartask.service.model.Suggestions;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Glenn Van Schil
 *         Created on 8/02/2016
 */
@Service
public class SuggestionService {

    public Suggestions getSuggestions(String word) {

        String uri = "http://localhost:9200/smartask/_suggest";
        String json = "{\"suggestions\":{\"text\":\"" + word + "\",\"completion\":{\"field\":\"suggest\",\"size\":\"10\",\"fuzzy\":{\"fuzziness\":\"AUTO\"}}}}";
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        Suggestions response = restTemplate.postForObject(uri, json, Suggestions.class);
        return response;
    }
}
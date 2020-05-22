import org.junit.Test;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static org.assertj.core.api.Assertions.assertThat;

public class SomeTest {

    @Test
    public void test1() throws Exception {
        String url = UriComponentsBuilder.fromUriString("http://www.app.com/one%20two/")
                .queryParam("price", encodeUtf8("€25"))
                .queryParam("name", encodeUtf8("Réne e Suzanne"))
                .queryParam("config", encodeUtf8("{\"f1\":34,\"f2\":\"&?\"}"))
                .build()
                .toUriString();

        assertThat(url).isEqualTo("http://www.app.com/one%20two/?price=%E2%82%AC25&name=R%C3%A9ne+e+Suzanne&config=%7B%22f1%22%3A34%2C%22f2%22%3A%22%26%3F%22%7D");
    }

    @Test
    public void test2() throws Exception {
        String url = UriComponentsBuilder.fromUriString("http://www.berry.nz/one/two?return=%7B%22abc%22%3A%22%25%5E%3F%22%7D")
                .queryParam("price", encodeUtf8("€25"))
                .queryParam("name", encodeUtf8("Réne e Suzanne"))
                .queryParam("config", encodeUtf8("{\"f1\":34,\"f2\":\"&?\"}"))
                .build()
                .toUriString();

        assertThat(url).isEqualTo("http://www.berry.nz/one/two?return=%7B%22abc%22%3A%22%25%5E%3F%22%7D&price=%E2%82%AC25&name=R%C3%A9ne+e+Suzanne&config=%7B%22f1%22%3A34%2C%22f2%22%3A%22%26%3F%22%7D");
    }

    @Test
    public void test3() throws Exception {
        String url = UriComponentsBuilder.fromUriString("http://www.soil.au:8080/one/two#section-2")
                .queryParam("price", encodeUtf8("€25"))
                .queryParam("name", encodeUtf8("Réne e Suzanne"))
                .queryParam("config", encodeUtf8("{\"f1\":34,\"f2\":\"&?\"}"))
                .build()
                .toUriString();

        assertThat(url).isEqualTo("http://www.soil.au:8080/one/two?price=%E2%82%AC25&name=R%C3%A9ne+e+Suzanne&config=%7B%22f1%22%3A34%2C%22f2%22%3A%22%26%3F%22%7D#section-2");
    }

    private static String encodeUtf8(String val) throws UnsupportedEncodingException {
        return URLEncoder.encode(val, "UTF-8");
    }
}
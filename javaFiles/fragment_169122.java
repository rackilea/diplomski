import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@RestController
public class FluxDateTime {
    @GetMapping(value = "/time", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Data> getData() {
        List<Data> data = Arrays.asList(
                new Data(1, 1),
                new Data(2, 2),
                new Data(3, 3),
                new Data(4, 5),
                new Data(5, 8),
                new Data(6, 13),
                new Data(7, 21),
                new Data(8, 34),
                new Data(9, 55));

        return Flux.fromIterable(data)
                .delayUntil(d -> Mono.delay(Duration.ofSeconds(d.getDelay())));
    }

    /* Keep in mind that empty constructor, getters/setters
       are purely only for JSON serialization */
    private final class Data {
        private int id;
        private int delay;

        public Data() {}

        public Data(int id, int delay) {
            this.id = id;
            this.delay = delay;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getDelay() {
            return delay;
        }

        public void setDelay(int delay) {
            this.delay = delay;
        }
    }
}
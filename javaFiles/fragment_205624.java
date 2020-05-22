import org.springframework.context.annotation.Bean;
import javax.servlet.http.HttpSessionListener;

@Bean
public HttpSessionListener httpSessionListener(){
    // MySessionListener should implement javax.servlet.http.HttpSessionListener
    return new MySessionListener(); 
}
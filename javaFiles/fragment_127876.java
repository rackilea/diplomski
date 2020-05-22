import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;

public interface AsyncServletTaskProcessor {

    void process(AsyncContext ctx) throws IOException, ServletException;
}
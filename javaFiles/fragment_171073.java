import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Example2 {
    public void example(HttpServletRequest request) {

        List<String> uploadedFileIds = Collections
                .list(request.getParameterNames())
                .stream()
                .filter(parameterName -> parameterName.startsWith("MultiFileId_"))
                .flatMap(parameterName -> Arrays.stream(
                        request.getParameterValues(parameterName)))
                .collect(Collectors.toList());
    }
}
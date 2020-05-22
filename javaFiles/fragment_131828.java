import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

import javax.servlet.http.HttpServletRequest;

public class PostAndPutCommonsMultipartResolver extends CommonsMultipartResolver {

    private static final String POST_METHOD = "POST";
    private static final String PUT_METHOD = "PUT";

    @Override
    public boolean isMultipart(HttpServletRequest request) {

        boolean isMultipartRequest = false;

        if (request != null) {

            if (POST_METHOD.equalsIgnoreCase(request.getMethod()) || PUT_METHOD.equalsIgnoreCase(request.getMethod())) {

                isMultipartRequest = FileUploadBase.isMultipartContent(new ServletRequestContext(request));
            }
        }

        return isMultipartRequest;
    }
}
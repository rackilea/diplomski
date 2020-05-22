import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

public class MyPortlet extends GenericPortlet {

    @Override
    public void serveResource(ResourceRequest request, ResourceResponse resourceResponse) throws PortletException, IOException {

        final HttpServletRequest originalHttpServletRequest = portalService.getOriginalHttpServletRequest(request);
        final boolean multipartContent = FileUploadBase.isMultipartContent(new ServletRequestContext(originalHttpServletRequest));
        if (multipartContent) {
            // Create a factory for disk-based file items
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // Set factory constraints
            factory.setSizeThreshold(yourMaxMemorySize);
            factory.setRepository(yourTempDirectory);
            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);
            // Set overall request size constraint
            upload.setSizeMax(yourMaxRequestSize);

            List<FileItem> items = upload.parseRequest(originalHttpServletRequest);

            // Process the uploaded items
            Iterator<FileItem> iter = items.iterator();
            while (iter.hasNext()) {
                FileItem thisItem = (FileItem) iter.next();
                final String fieldName = thisItem.getFieldName();
                // if an element is a form field
                if (thisItem.isFormField()) {
                    if (fieldName.equals("yourfieldformparam")) {
                        String value = thisItem.getString();
                        // Do something with the value
                    }
                } else {
                    // if its an attachment you can do...
                    String fileName = item.getName();
                    String contentType = item.getContentType();
                    boolean isInMemory = item.isInMemory();
                    long sizeInBytes = item.getSize();

                    File fileOut = File.createTempFile(IMieiPagamentiConstants.FILE_PREFIX, null);
                    // delete on jvm exit
                    fileOut.deleteOnExit();
                    // write the file
                    thisItem.write(fileOut);

                    //...
                }
            }
        }
    }
}
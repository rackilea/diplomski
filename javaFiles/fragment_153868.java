import java.util.Iterator;
import org.jboss.weld.context.NonexistentConversationException;

import javax.faces.FacesException;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

public class ViewExpiredExceptionHandler
        extends ExceptionHandlerWrapper {

    private ExceptionHandler wrapped;

    public ViewExpiredExceptionHandler(ExceptionHandler wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public ExceptionHandler getWrapped() {
        return this.wrapped;
    }

    @Override
    public void handle()
            throws FacesException {

        for (Iterator<ExceptionQueuedEvent> i =
                getUnhandledExceptionQueuedEvents().iterator();
                i.hasNext();) {
            ExceptionQueuedEvent event = i.next();
            ExceptionQueuedEventContext context =
                    (ExceptionQueuedEventContext) event.getSource();
            Throwable t = context.getException();

            if (t instanceof ViewExpiredException
                    || t instanceof NonexistentConversationException) {

                FacesContext fc = FacesContext.getCurrentInstance();
                try {

                    if (!fc.getExternalContext().isResponseCommitted()) {
                        fc.getExternalContext().redirect("index.xhtml");
                    }
                    fc.renderResponse();
                    break;
                } catch (Exception ex) {
                    throw new FacesException(ex);
                } finally {
                    i.remove();
                }
            }
        }
        getWrapped().handle();
    }
}
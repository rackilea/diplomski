package ch.hasselba.xpages;

import java.util.List;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import com.ibm.xsp.complex.Parameter;
import com.ibm.xsp.component.xp.XspEventHandler;

public class MyActionListener implements javax.faces.event.ActionListener {

    public void processAction(ActionEvent event)
            throws AbortProcessingException {
        XspEventHandler eventHandler = (XspEventHandler) event.getSource();
        List<Parameter> params = eventHandler.getParameters();
        for (Parameter p : params) {
            System.out.println(p.getName() + " -> " + p.getValue());
        }
    }
}
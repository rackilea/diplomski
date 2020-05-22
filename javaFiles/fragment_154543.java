//note that I've put my class inside the package, 
//which is used for other default generators in cxf
package org.apache.cxf.tools.wsdlto.frontend.jaxws.generators;

import java.util.List;
import java.util.Map;

import org.apache.cxf.tools.common.ToolContext;
import org.apache.cxf.tools.common.ToolException;
import org.apache.cxf.tools.common.model.JavaPort;
import org.apache.cxf.tools.common.model.JavaServiceClass;

public class CustomSEIGenerator extends SEIGenerator {

    @Override
    public void generate(ToolContext penv) throws ToolException {
        //no streams, because we still on java 7
        //fetch all services
        Map<String, JavaServiceClass> ss = penv.getJavaModel().getServiceClasses();
        for (Map.Entry<String, JavaServiceClass> s : ss.entrySet()) {
            //fetch all ports from each service
            for (JavaPort port : s.getValue().getPorts()) {
                //set custom name to each port
                port.setName("_" + port.getName);
            }
        }
    }
}
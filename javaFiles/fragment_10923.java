package ic.ac.uk.icdev.rjmtest.wladminserversensor.wsdlgen;

import ic.ac.uk.icdev.rjmtest.wladminserversensor.wsdlgentypes.RequestSOAEndpointsMessageType;
import ic.ac.uk.icdev.rjmtest.wladminserversensor.wsdlgentypes.ResponseSOAEndpointsMessageType;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import java.util.Hashtable;

import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.jms.Destination;

import javax.jws.WebService;

import javax.management.MBeanServer;

import javax.management.ObjectName;

import javax.management.RuntimeMBeanException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;


@WebService(serviceName = "mainService", targetNamespace = "urn:WLAdminServerSensor", portName = "mainPort", endpointInterface = "ic.ac.uk.icdev.rjmtest.wladminserversensor.wsdlgen.Main_pt", wsdlLocation = "/WEB-INF/wsdl/service.wsdl")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class Main_ptImpl {
    public Main_ptImpl() {
    }

    private byte[] exportMetadataFile(MBeanServer p_server) throws Exception {
        //Reading from SOA1
        ObjectName mdsSOA1Bean = new ObjectName("oracle.mds.lcm:Location=WLS_SOA1,name=MDSAppRuntime,type=MDSAppRuntime,Application=soa-infra");


        //String streamID = UUID.randomUUID().toString();
        String streamID = (String) p_server.invoke(mdsSOA1Bean, "startExport",null,null);

        String[] docs = new String[1];
        docs[0] = "/apps/AIAMetaData/dvm/XXIC_DVM_SOAEndpoints.dvm";


        Object[] x = new Object[9];
        String[] y = new String[9];
        int c=0;
        x[c] = streamID;            y[c] = String.class.getName();  c++;
        x[c] = docs;            y[c] = String[].class.getName();  c++;
        x[c] = new String[0];            y[c] = String[].class.getName();  c++; //restrict custs to
        x[c] = false;            y[c] = boolean.class.getName();  c++;
        x[c] = false;            y[c] = boolean.class.getName();  c++;
        x[c] = false;            y[c] = boolean.class.getName();  c++;
        x[c] = false;            y[c] = boolean.class.getName();  c++;
        x[c] = "";            y[c] = String.class.getName();  c++;
        x[c] = "";            y[c] = String.class.getName();  c++;
        javax.management.openmbean.TabularData ret = (javax.management.openmbean.TabularData) p_server.invoke(mdsSOA1Bean, "doExport",x,y);

        Object[] x0 = new Object[2];
        String[] y0 = new String[2];
        c=0;
        x0[c] = streamID;            y0[c] = String.class.getName();  c++;
        x0[c] = 4096;            y0[c] = int.class.getName();  c++;
        byte[] fil = (byte[]) p_server.invoke(mdsSOA1Bean, "get",x0,y0);



        Object[] x2 = new Object[1];
        x2[0] = streamID;
        String[] y2 = new String[1];
        y2[0] = String.class.getName();
        p_server.invoke(mdsSOA1Bean, "endExport",x2,y2);

        //We get a zip file with the MDS file contained inside it. We must extract it out
        ZipInputStream zin = new ZipInputStream(new ByteArrayInputStream(fil));
        ZipEntry ze = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream(fil.length);
        while ((ze = zin.getNextEntry()) != null) {
            if (true) {
                byte[] buffer = new byte[8192];
                int len;
                while ((len = zin.read(buffer)) != -1) {
                    bos.write(buffer, 0, len);
                }
                bos.close();
                break;
            }
        }        
        return bos.toByteArray();

    }

    private ResponseSOAEndpointsMessageType run(RequestSOAEndpointsMessageType requestSOAEndpointsInputPart) throws Exception {

        Hashtable env = new Hashtable();
        //Username and password only required for enurmrating parittipons
        //env.put(Context.SECURITY_PRINCIPAL, "weblogic");
        //env.put(Context.SECURITY_CREDENTIALS, "password");
        env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");

        Context jndiContext = null;

        try {
            jndiContext = new InitialContext(env);
        } catch (NamingException e) {
            throw new Exception("Creating initial context NamingException:" + e.toString());
        }

        Destination passedDest = null;

        //MBeanServer server = (MBeanServer)jndiContext.lookup("java:comp/env/jmx/runtime"); 
        MBeanServer server = (MBeanServer)jndiContext.lookup("java:comp/env/jmx/domainRuntime"); 

    /*
     *  Code to enurmrate MDS repos and partitions - not needed to read actual file
        ObjectName service = new ObjectName(
"com.bea:Name=DomainRuntimeService,Type=weblogic.management.mbeanservers.domainruntime.DomainRuntimeServiceMBean"
        );


        ObjectName mdsBean = new ObjectName("oracle.mds.lcm:name=MDSDomainRuntime,type=MDSDomainRuntime");

        String[] repositories = (String[]) server.invoke(mdsBean, "listRepositories",null,null);

        ObjectName rep = null;
        for (int c=0;c<repositories.length;c++) {
            ObjectName cur = new ObjectName(repositories[c]);
            if (cur.getKeyProperty("Name").equals("mds-owsm")) {
                rep = new ObjectName(repositories[c]);
            };
        }
        if (rep==null) throw new Exception("No mds-owsm repository found");

        Object[] x = new Object[1];
        x[0] = new String(rep.getKeyProperty("Name"));
        String[] y = new String[1];
        y[0] = String.class.getName();
        String[] partitions = (String[]) server.invoke(mdsBean, "listPartitions",x,y);

        String part = null;
        for (int c=0;c<partitions.length;c++) {
            if (partitions[c].equals("soa-infra")) {
                part = partitions[c];
            };
        }
        if (part==null) throw new Exception("Could not find partition soa-infra in mds");
        */       

        byte[] fil = exportMetadataFile(server);
        String s = new String(fil,"UTF-8");

        ResponseSOAEndpointsMessageType ret = new ResponseSOAEndpointsMessageType();
        ret.setOutput(s);
        return ret;

    }

    public ResponseSOAEndpointsMessageType querySOAEndpoints(RequestSOAEndpointsMessageType requestSOAEndpointsInputPart) {
        ResponseSOAEndpointsMessageType ret = new ResponseSOAEndpointsMessageType();
        try {
            return run(requestSOAEndpointsInputPart);
        } catch (RuntimeMBeanException e) {
            String st = "";
            for (int c=0;c<e.getStackTrace().length;c++) {
                st += "\n" + e.getStackTrace()[c].toString();
            }

            if (e.getTargetException()==null) {
                st += "\n\nTARG EXCEPTION IS NULL";
            } else {
                st += "\n\nTARG EXCEPTION: " + e.getTargetException().getMessage();
                for (int c=0;c<e.getTargetException().getStackTrace().length;c++) {
                    st += "\n" + e.getTargetException().getStackTrace()[c].toString();
                }
            }

            ret.setOutput("RuntimeMBeanException: " + e.getMessage() + "\n" + e.getLocalizedMessage() + "\n" + st);
            return ret;
        } catch (Exception e) {
            String st = "";
            for (int c=0;c<e.getStackTrace().length;c++) {
                st += "\n" + e.getStackTrace()[c].toString();
            }

            ret.setOutput("Exception: " + e.getMessage() + "\n" + e.getLocalizedMessage() + "\n" + st);
            return ret;
        }
    }
}
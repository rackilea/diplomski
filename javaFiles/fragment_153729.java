import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xsd.util.XSDResourceFactoryImpl;
import org.eclipse.xsd.util.XSDResourceImpl;
import org.eclipse.xsd.XSDSchema;

static ResourceSet resourceSet;
XSDResourceFactoryImpl rf = new XSDResourceFactoryImpl();
Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xsd", rf);
resourceSet = new ResourceSetImpl();
resourceSet.getLoadOptions().put(XSDResourceImpl.XSD_TRACK_LOCATION, Boolean.TRUE);
XSDResourceImpl rsrc = (XSDResourceImpl)(resourceSet.getResource(uri, true));
XSDSchema sch = rsrc.getSchema();
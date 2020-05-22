public static EObject loadEObjectFromString(String myModelXml, EPackage ePackage) throws IOException { 
    // Create a ResourceSet
    ResourceSet resourceSet = new ResourceSetImpl();
    // register XMIRegistryResourceFactoryIml
    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put
    (Resource.Factory.Registry.DEFAULT_EXTENSION, 
     new XMIResourceFactoryImpl());
     // register your epackage to the resource set so it has a reference to your ecore
     // you can get an instance to your epackage by calling YourEPackageClass.getInstace();
    resourceSet.getPackageRegistry().put(ePackage.getNsURI(), ePackage);
    Resource resource = resourceSet.createResource(URI.createURI("*.modelextension"));
    resource.load(new URIConverter.ReadableInputStream(myModelXml), null);
    // return the root model object and there you have it, all you need is to
    // cast it to the right EObject based on your model 
    return resource.getContents().get(0);
}
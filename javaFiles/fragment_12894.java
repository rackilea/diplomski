private EObject loadEObjectFromString(String model, EPackage ePackage) throws IOException { 
    ResourceSet resourceSet = new ResourceSetImpl();
    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new JsonResourceFactory());

    resourceSet.getPackageRegistry().put(ePackage.getNsURI(), ePackage);
    Resource resource = resourceSet.createResource(URI.createURI("*.extension"));
    InputStream stream = new ByteArrayInputStream(model.getBytes(StandardCharsets.UTF_8));
    resource.load(stream, null);

    return resource.getContents().get(0);
}
ResourceSet resourceSet = new ResourceSetImpl();
 resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("arxml", new XMIResourceImpl());

 URI uri = URI.createURI("http://example.myorganization.com/");
 Resource res = resourceSet.createResource(uri);

 // TODO add some content here
 // res.getContents().add(...)

 try{
    resource.save(new FileOutputStream("D:/User/file.xml"));
    java.lang.System.out.println("success");

 } catch (IOException e){
   java.lang.System.out.print("no");
 }
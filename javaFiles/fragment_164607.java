Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
Map<String, Object> m = reg.getExtensionToFactoryMap();
m.put("key", new XMIResourceFactoryImpl());
ResourceSet resSet = new ResourceSetImpl();
Resource resource = resSet.createResource(URI.createFileURI(fileName));
resource.getContents().add(data);
resource.save(Collections.EMPTY_MAP);
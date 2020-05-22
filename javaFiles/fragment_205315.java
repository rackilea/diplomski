final XJavaDoc xJavaDoc = XDocletTagSupport.getXJavaDoc();
  final XClass xClass = xJavaDoc.getXClass(clazz.getCanonicalName());

  // iterate over all fields in the angebot class and...
  for (Object field : xClass.getFields(true)) {
    final XField xfield = (XField) field;
    // ... check if it contains the corresponding field, ...
    if (xfield.getName().contains(fieldNameToLookFor)) {
      return xfield;
    }
  }
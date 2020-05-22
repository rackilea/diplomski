OntClass oc = model.getOntClass(NS + "ClassName");
for (ExtendedIterator<? extends OntResource> i = oc.listInstances(); i.hasNext();)
{
  OntResource or = i.next();
  Property labelProp = null;

  if (or.hasProperty( RDFS.label )) {
    labelProp = RDFS.label;
  }
  else if (or.hasProperty( SKOS.prefLabel )) {
    labelProp = SKOS.prefLabel;
  }

  // note: does not deal with lang tags
  String label = (labelProp != null) ? or.getProperty( labelProp ).getString() : "unknown";

  System.out.println("Resource " + or.getURI() + " is labelled: " + label ); 
}
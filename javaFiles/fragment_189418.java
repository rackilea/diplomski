// always use a ValueFactory, avoid instantiating URIImpl directly.
 ValueFactory vf = ValueFactoryImpl().getInstance(); 
 URI c = vf.createURI(C.getFullIRI());
 URI prop = vf.createURI(property.getFullIRI())

 // create a new Model for the resulting triple collection
 Model result = new LinkedHashModel();

 // filter on the supplied property
 Model propMatches = triples.filter(null, prop, null);
 for(Resource subject: propMatches.subjects()) {

    // check if the selected subject is of the supplied type
    if (triples.contains(subject, RDF.TYPE, c)) {
          // add the type triple to the result
          result.add(subject, RDF.TYPE, c);

          // add the property triple(s) to the result 
          result.addAll(propMatches.filter(subject, null, null));
    }
 }
 return result;
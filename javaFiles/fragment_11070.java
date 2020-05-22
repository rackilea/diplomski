String NS = "http://example.org/example#";

// create ex:Man class
OntClass man = model.createClass( NS + "Man" );

// create individual ex:jack
Individual jack = model.createIndividual( NS + "jack", man );

// create some properties - probably better to use FOAF here really
DatatypeProperty age = model.createDatatypeProperty( NS + "age" );
DatatypeProperty address = model.createDatatypeProperty( NS + "address" );

jack.addProperty( age, model.createTypedLiteral( 50 ) )
    .addProperty( address, model.createLiteral( "France" ) );
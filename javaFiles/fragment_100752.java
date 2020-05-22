ValueFactory vf = SimpleValueFactory.getInstance();

// the subject which is the IRI of the terminal
IRI s = vf.createIRI("**http://example.org/data#_8fd6a918-5a8d-42f2-ae19-3ee77bc76911**");

// the predicate which is the IRI of the property cim:Terminal.ConductingEquipment
IRI p = vf.createIRI("http://example.org/Terminal.ConductingEquipment");

// filter by subject and predicate
Model filteredModel = model.filter(s, p, null);

// get the object, if one exists
Resource acLineSegment = Models.objectResource(filteredModel).orElse(null);
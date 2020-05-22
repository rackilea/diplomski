// this assumes that "Boat" is mapped as many-to-one "boat" property on "Person"
DetachedCriteria boatCriteria = personCriteria.createCriteria("boat");
boatCriteria.add(Restriction.eq("color", "red"));

// same for house
DetachedCriteria houseCriteria = personCriteria.createCriteria("house");
houseCriteria.add(Restriction.eq("color", "blue"));

// when you're all done you search based on "personCriteria"
personCriteria.getExecutableCriteria(session).list();
if (person.getId() != 0) {
     //if exists update obj
     session.update(person);
} else {
     session.save(person);
}
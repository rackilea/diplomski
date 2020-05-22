List<People> toSave = new ArrayList<>();

for(Long id : selectedPeople){
   People people = new People();
   people.setId(id);
   toSave.add(people);
}
myList.setPeople(toSave);
session.save(myList);
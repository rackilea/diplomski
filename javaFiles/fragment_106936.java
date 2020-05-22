methodX classA - 
 List<String> locaNamesList = person.getNamesList();
 locaNamesList.clear();

Somewhere else
methodY classB -
List<String> locaNamesList = person.getNamesList(); // note the same person instance should be used.
//locaNamesList will be empty here
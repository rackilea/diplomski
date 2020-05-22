public String getMotherTree(int id) {
  String output = "";
  if (existDog(id)) {
    Dog mother = GetMother(id);
    output += mother.toString();
    int morId = mother.getId();
    return output + ", " + getMotherTree(morId); //recursion
  }

  //return an empty string if the dog doesn't exist
  //this basically ends the recursion
  return output;
}
boolean found = false;
for (int j = 0; j < p; j++){
  if (data.get(j).equals(tempTable)){
    found = true;
    break;
  }
}
if (!found)
  data.add(tempTable);
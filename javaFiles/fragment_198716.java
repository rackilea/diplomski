int i;
for(i = 0; i < haystackList.size(); i++){
  if(haystackList.get(i).get("model").equals(needle)){
    // Break
  }
}

if(i == haystackList.size()){
// Failure
} else {
// Success
}
function myStartsWith(name, clanName){
  name = name.toLowerCase();
  clanName = clanName.toLowerCase();
  var cNameLen = clanName.length;
  var nameLen = name.length;
  return cNameLen < nameLen && name.substring(0, cNameLen) === clanName;
}
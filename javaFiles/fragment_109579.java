function createRandomHexValues(nValues) {
  var chassis  = "";
  var CHARACTERS = "abcdefghijklmnopqrstuvwxyz";

  for (var i = 0; i < nValues ; i++)
    chassis  += CHARACTERS.charAt(Math.floor(Math.random() * CHARACTERS.length));

  return chassis ;
}
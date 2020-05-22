function getString() {
  var str = "";
  for (counter = 0; counter <= 9; counter++) {
    var randomNum = 0 + parseInt(Math.floor(Math.random() * (127 - 33 + 1) + 33));
    str += String.fromCharCode(randomNum);
  }
  return str;
}
for (i = 0; i < 10; i++)
  console.log(getString());
function myStartsWith(name, clanName){
  name = name.toLowerCase();
  clanName = clanName.toLowerCase();
  var cNameLen = clanName.length;
  var nameLen = name.length;
  return cNameLen < nameLen && name.substring(0, cNameLen) === clanName;
}

function nameWoClan(name) {
  if (!name)
    return null;
  var clanName = '';
  for (var i = 0; i < clansPre.length; i++) {
    var match = myStartsWith(name, clansPre[i]);

    if (match) {
      clanName = name.substring(0, clansPre[i].length);
      name = name.substring(clansPre[i].length);
      break;
    }
  }
  return {
    clanName: clanName,
    playerName: name
  }
}
function testing(){

  //get the sheet to query
  var ss = SpreadsheetApp.getActiveSpreadsheet();
  var sheet = ss.getSheets()[2];

  //get the last row index
  var lastRow = sheet.getLastRow();

  //get the player names range O2:O18 //removes header
  var range = sheet.getRange(2, 15, lastRow);

  //get the values for the range
  var data = range.getValues()
  var names = [];

  //iterate the range getting the records. note index [0] as values is a multi-dimension name
  for(var i = 0;i< lastRow;i++){
    var name = nameWoClan(data[i][0]);
    if(name)
    {
      names.push(name); 
    }
  }
  var n = names;
}
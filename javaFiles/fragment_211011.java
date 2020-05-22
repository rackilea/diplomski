$('#extract-name').on('click', function() {
  var names = $('#player-names').val().split('\n');
  $('#names-list-body').html(''); //clear the table
  names.forEach(function(item, index) {
    var name = nameWoClan(item);
    if (name) {
      $('#names-list-body').append($('<tr><td>' + item + '</td><td>' + name.clanName + '</td><td>' + name.playerName + '</td></tr>'));
    }
  });

});

var clansPre = ["va|", "RED|", ".rC|", "!s]", "vaQ'", "[RUSS]", "cm|", "Crowd>", "oo|"];

function nameWoClan(name) {
  if (!name)
    return null;
  var clanName = '';
  for (var i = 0; i < clansPre.length; i++) {
    if (name.toLowerCase().startsWith(clansPre[i].toLowerCase())) {
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
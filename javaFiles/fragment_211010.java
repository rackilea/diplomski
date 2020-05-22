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
sendMessage = function(path, opt_param) {
  path += '?g=' + state.game_key;
  if (opt_param) {
    path += '&' + opt_param;
  }
  var xhr = new XMLHttpRequest();
  xhr.open('POST', path, true);
  xhr.send();
};
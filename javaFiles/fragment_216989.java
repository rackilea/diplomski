$.getJSON(url, function(data) {
  var l = $('#mylist').empty();
  $.each(data, function(index, value) {
    l.append($('<li>' + value + '</li>'));
  });
});
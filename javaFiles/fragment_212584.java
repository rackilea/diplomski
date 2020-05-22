$(function() {

  var resultCountries = ['Germany', 'France', 'Spain'];

  $('[data-toggle="popover"]').popover({
    html: true,
    content: function() {
      var result = $();
      for (var i in resultCountries) {
        result = result.add(('<span>' + i + ' &ndash; ' + resultCountries[i] + '<span/><br/>'));
        console.log(i, resultCountries[i]);
      }
      return result;
    }

  });

});
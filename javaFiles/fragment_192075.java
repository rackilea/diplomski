$('#test').click(function(){
  
  // I replaced the string with the input value for testing
  var tmp = $('input').val().replace(/.*?:\/\//g, "").replace(/\/+$/,'');
  arr = tmp.split('/');
  
  // Clearing the output here
  $('div').html('');
  while(arr.length > 1) {
    tmp = 'http://' + arr.join('/');
    
    // Appending the current result
    $('div').append('<p>' + tmp + '/</p>');
    $('a[href="' + tmp + '"], a[href="' + tmp + '/"]').parent().addClass('active');
    arr = arr.slice(0,-1);
  }
});
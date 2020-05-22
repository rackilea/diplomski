$.ajax({
    type: 'get', // it's easier to read GET request parameters
    url: 'masterpaket',
    dataType: 'JSON',
    data: { 
      loadProds: 1,
      test: JSON.stringify(test) // look here!
    },
    success: function(data) {

    },
    error: function(data) {
        alert('fail');
    }
});
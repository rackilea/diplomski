$.ajax({
    url: '/users/' + someUserId,
    type: 'DELETE',
    success: function(result) {
        // Do something with the result
    }
});
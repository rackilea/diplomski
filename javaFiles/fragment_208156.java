updateUser: function(user, id){
      return $http.put('http://localhost:8080/user/' + id, user)
        .then(
            function (response) {
                return response.data;
            },
            function (errResponse) {
                console.error('Error while updating user');
                return $q.reject(errResponse);
            }
      );

},
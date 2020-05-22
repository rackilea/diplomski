$scope.submitForm = function() {

        var params = {
            "name" : $scope.name,
            "username" : $scope.username,
            "email" : $scope.email
        };

        var data = angular.toJson(params);
        $http( {
            method : 'POST',
            url : '/angular/studentForm.action',
            data : 'value=' + data,
            headers : {
                'Content-Type' : 'application/x-www-form-urlencoded'
            }
        }).success(function(data) {
            if (data.errors) {
                $scope.errorname = data.errors.name;
                $scope.errorUsername = data.errors.username;
                $scope.erroremail = data.errors.email;
            } else {
                console.log(data);
                $scope.message = data;

            }
        }).error(function(data, status) {
            return false;
        });
    };
});
angular.module("mainApp").controller("StudentController", function($scope, $http){
    $scope.fileList = [];

    $scope.uploadFormData = function() {
        // Code to upload file.
        // Ex:
        $http(...).success(function(response){
             $scope.fileList = response.list;
        });
    };
});
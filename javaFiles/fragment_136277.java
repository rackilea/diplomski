//create module
var app = angular.module('myApp', []);

//add controler to module
app.controller('MyController', MyController);

//add dependecies
MyController.$inject = ['$scope', '$http'];

//controller function
function MyController($scope,$http) {
        $scope.getDataFromServer = function() {
                $http({
                        method : 'GET',
                        url : 'javaAngularJS'
                }).success(function(data, status, headers, config) {
                        $scope.person = data;
                     // this callback will be called asynchronously
                        // when the response is available
                }).error(function(data, status, headers, config) {
                        // called asynchronously if an error occurs
                        // or server returns response with an error status.
                });

        };
}
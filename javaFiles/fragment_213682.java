<script>
    var app = angular.module('myApp', []);

    function MyController($scope, $http) {
    $scope.getDataFromServer = function() {
            $http.get("angularAction.action").success(
                    function(response) {
                        console.log(response);
                            $scope.person = response.data;
                    }).error(function(data, status, headers, config) {
                                    // called asynchronously if an error occurs
                                    // or server returns response with an error status.
            });
    };
    };
    </script>
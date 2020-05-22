function Hello($scope, $http) {

    var config = {
            headers : {
                'Accept': 'application/json',
                'Content-Type': 'application/x-www-form-urlencoded',
                'Authorization': 'Basic ' +btoa('clientapp:123456654321')
            }
        }
    var payload ="password=spring&username=roy&grant_type=password&scope=read%20write&client_secret=123456&client_id=clientapp";

    $http.post('http://localhost:8080/oauth/token',payload, config).
    success(function(data, status, headers, config) {
        $scope.data = data;
    }).
    error(function(data, status, headers, config) {
        $scope.data = data; 
    }); 
}
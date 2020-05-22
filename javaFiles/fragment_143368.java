$scope.formData = {}; //should set object on init.
$scope.submit = function() {
    var response = $http.post('submitmock',{ mockForm: formData}); //passing mockForm
    response.success(function(data, status, headers, config) {
        $scope.list.push(data);
    });
    response.error(function(data, status, headers, config) {
        alert("Exception details: " + JSON.stringify({
            data: $scope.formData //used formData model here
        }));
    });

    //Empty list data after process
    $scope.list = [];
};
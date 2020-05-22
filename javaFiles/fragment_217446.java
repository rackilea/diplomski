$scope.execute = function() {
    $http({
        method : 'GET',
        url : 'trigger',
        params : {
                     selectedItems : $scope.selectedItems
                }
        }).success(
            function(data, status, headers, config) {
        }).error(
            function(data, status, headers, config) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
    });
                        };
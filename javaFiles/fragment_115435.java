$scope.submitOffer = function () {
    $http({
        method: 'POST',
        url: '/offer/submitOffer',
        data: {
            offerType: $scope.formData.offerType,
            offerTitle: $scope.formData.offerTitle
        }
    }).
    success(function (data, status, headers, config) {
        $scope.successMsg = data;
    }).
    error(function (data, status, headers, config) {
        if (status == 400) {
            $scope.errMessages = data;
        } else {
            alert('Unexpected server error.');
        }

    });
};
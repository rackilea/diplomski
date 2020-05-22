$upload.upload({
    method : 'POST',
    url : 'sendemail/attachment',
    file : $scope.file,
    data : $scope.emailData
}).success(function(response) {
    console.log("Success");
}).error(function(error) {
    console.log("Error");
});
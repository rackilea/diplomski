$upload.upload({
    url : 'saveUserData',
    file : yourFile,
    data : $scope.userDataBean,
    method : 'POST'
});
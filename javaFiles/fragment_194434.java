$http.get('IcdCodesAction')
.success(function(response){
     console.log("this is the serialzied action -> " + response);
     console.log("this is what I want:  " + response.icdCodes);
     $scope.icdcodes = response.icdCodes;
});
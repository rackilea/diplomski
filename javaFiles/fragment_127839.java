$http({method: 'GET', url: 'http://yourservleturl' })
.success(function(jsonStringFromServlet){
  $scope.newData = jsonStringFromServlet;
})
.error(function(){
  $scope.error = true;
});
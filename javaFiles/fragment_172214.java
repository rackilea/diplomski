$scope.someFunction = function(){
  var bothVar = {'value1': $scope.value1, 'value2': $scope.value2};
  MySvcController.MySvcFunction(bothVar).then(
    function (response) {
      //display on screen 
});
// note the import of AuditService
app.controller('listCtrl', function ($scope, $http,$route, AuditService) { 

// other code here


// If insert is successful, then update $scope by calling the newly updated collection. 
// (this is chaining the events using then())
$scope.add = function(bugInfo) {
  AuditService.add().then(
    function(){ // successcallback
      AuditService.get().then(
        function(data){ // success
          $scope.audit = data; 
        },
        function(){ // error
          console.log('error reading data ' + error)
        })
    },
    function(error){ // errorcallback
      console.log('error inserting data ' + error)
    })  
});
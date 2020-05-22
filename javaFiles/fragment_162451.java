angular.element(document).ready(function () {
            angular.bootstrap(document, ['App']);
});

angular.module('App', [])
  .controller('Controller', ['$document', '$scope', function($document, $scope) {
      $scope.user = {'name' : "Hello"};
      $document.on('myevent', function() {
          $scope.$apply(
              function() {
                     $scope.user.name = "hello my event!";
              });

      })
  }]);

// end of angular/ionic app

var button = document.getElementById("emit");

button.onclick = function() {
    var event = new CustomEvent("myevent", {});
    document.dispatchEvent(event);
};
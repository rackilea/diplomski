angular.module('app', ['notifyme']).  controller('appcontroller', function($scope, NotifyMe) {
                $scope.nofity = function(){
                  var title = "I'm from Angular ?";
                  var body = 'This is a simple demo for the notification API Angular Service';
                  NotifyMe.launch(title, {
                      body: body,
                      onclick:function(){
                          console.log("On Click Triggered");
                      },
                      onerror:function(){
                          console.log("On Error Triggered");
                      },
                      onclose:function(){
                          console.log("On Close Triggered");
                      }
                  });
                };
            });
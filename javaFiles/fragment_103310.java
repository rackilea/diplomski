$scope.uploadfile  = function(jes) {

                /** Getting File from Form **/
                $scope.file = document.getElementById('myFile').files[0];

                /** Getting Label from Form **/
                var label = $scope.iconLabel;

                /** Validating form data **/
                $scope.result = $scope.validateData(label,$scope.file);

                if($scope.result == true){
                    /** Creating formdata object seeting form values **/
                    var formData = new $window.FormData();
                    formData.append("file", $scope.file);
                    formData.append("label", label);
                    formData.append("id", $scope.id);

                    /** Making service call to REST API **/
                    $http.post("uploadfile/save",formData,config).success(function(response) {
                        $scope.result = "SUCCESS";
                    }).error(function(response, status) {
                        if (status === 400) {
                            w20MessageService.addMessageErreur(data.message, "msgGererParam");
                        } else {
                            w20MessageService.addMessageErreur("eox.message.error.load.traitement", "msgGererParam");
                        }
                    });
                }
            };
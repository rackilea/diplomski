$scope.continueFileUpload=function (){
var uploadUrl=serverUrl+"continueFileUpload";
var formData=new FormData();
formData.append("file",file.files[0]);
 $http({
        method: 'POST',
        url: uploadUrl,
        headers: {'Content-Type': undefined},
        data: formData,
        transformRequest: function(data, headersGetterFunction) {
                        return data;
         }
     })
    .success(function(data, status) {   
                    alert("success");
     })

};
$http.get("first").then(function (res) {
    console.log(res);
    $scope.myData = res.data.jso;
}, function (error) {
   console.error(error);
});
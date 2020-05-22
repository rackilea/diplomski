app.factory('call2',['$q','$http',function ($q,$http) {
    var url = 'whatever url';
    var defer = $q.defer();
    $http.get(url).then(function (resp) {
        defer.resolve($http.get(resp.data)); 
        //resp.data contains the returned by $http request URL object
    });
    return defer.promise;
}]);
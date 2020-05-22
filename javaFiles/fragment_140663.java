app.factory('call2', ['$q', '$resource', function ($q, $resource) {
   var url = 'whatever url';
   var defer = $q.defer();
   $resource(url).get(function (resp) {
   defer.resolve($resource(resp.url).get().$promise);
  });
  return defer.promise;
}]);
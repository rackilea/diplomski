app.factory('AuditService', function($http) {
  var get = function() {
    return $http.get("/api/...") // returns a promise
  };

  var add = function() {
    return $http.post("/api/...") // returns a promise
  };

  return {
    get: get,
    add: add
  }
});
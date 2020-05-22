$http.get('http://localhost:8080/AngularGET/AtpPlayers').then(function (data, status, headers, config) {
    $scope.atp = data;
    alert('OK');
}, function (data, status, headers, config) {
    alert('NU');
});
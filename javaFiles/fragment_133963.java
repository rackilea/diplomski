$http.get('http://localhost:8080/AngularGET/AtpPlayers').then(function (response) {
    $scope.atp = response.data;
    alert('OK');
}, function (response) {
    alert('NU');
});
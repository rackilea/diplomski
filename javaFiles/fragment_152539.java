$http({
    method: 'POST',
    url: '/myservlet',
    data: { method: 'my_method', param1 : $("#param1").val(), param 2: ... }
}).success(function(data) {

}).error(function(data) {

});
angular.module('xxxxxxxxApp')
    .factory('XxxxxxServiceCSV', function ($http) {
        return {
            downloadCsv: function () {
            return $http.get('api/downloadCSV', { responseType: 'arraybuffer' }).then(function (response) {
                return response;
            });
        }
    };
});
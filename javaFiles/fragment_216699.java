angular.module("mainApp").directive('listFiles', function() {
    var template = '<table border="1" cellspacing="0" cellpadding="4">';
    template += '<tr ng-repeat="row in rows">';
    template += '<td ng-repeat="column in row.split(',')">{{column}}</td>';
    template += '</tr>';

    return {
        restrict: 'E',
        replace: true,
        template : template,    
        scope: {
            rows: '='
        }
    };
});
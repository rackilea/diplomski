(function() {
    'use strict';

    angular
        .module('myApp')
        .controller('MyController', MyController);

    MyController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance'];

    function MyController ($timeout, $scope, $stateParams, $uibModalInstance) {
        var vm = this;
        vm.clear = clear;
        vm.dwl = dwl;

        function dwl (id) {
            window.location = "http://localhost:8080/file/"+id;
            vm.clear();
        }

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }
    }
})();
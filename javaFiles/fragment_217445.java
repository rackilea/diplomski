$scope.selectedItems = [];
$scope.toggleSelection = function toggleSelection(name) {
    var idx = $scope.selectedItems.indexOf(name);
    // is currently selected
    if (idx > -1) {
        $scope.selectedItems.splice(idx, 1);
    }
    // is newly selected
    else {
        $scope.selectedItems.push(name);
    }
};
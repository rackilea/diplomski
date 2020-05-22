$scope.map={};
//  Add header data
$scope.addToMap=function()
{
    $scope.map[$scope.key]=$scope.value;
    $scope.key="";    //clear the textbox
    $scope.value="";  //clear the textbox
};
$scope.html = '&quot;12.10 On-Going Submission of &quot;&quot;Made Up&quot;&quot; Samples.&quot;'
$scope.renderHTML = function(html_code)
{
    var decoded = angular.element('<textarea />').html(html_code).text();
    return $sce.trustAsHtml(decoded);
};
<html lang="en" ng-app="springChat" xmlns:th="http://www.springframework.org/schema/beans">
<head>
    ...
    <meta name="_csrf" th:content="${_csrf.token}"/>
    <meta name="_csrf_parameter_name" th:content="${_csrf.parameterName}"/>

....
</body>     
<script type="application/javascript">

    $('#login-form').submit(function (ev) {
        ev.preventDefault(); // to stop the form from submitting
        var token = $("meta[name='_csrf']").attr("content");
        var paramName = $("meta[name='_csrf_parameter_name']").attr("content");
        $('<input>').attr('type', 'hidden').attr('name', paramName).attr('value', token).appendTo('#login-form');

        this.submit(); 
    });
</script>
</html>
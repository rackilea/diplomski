<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script>
function displayErrors() {  
   alert("<form:errors path='*'>");
}
</script>
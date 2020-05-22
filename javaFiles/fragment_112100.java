<script>
        function submitOthers(){
            document.getElementById('form1').submit();
            document.getElementById('form2').submit();
        }
    </script>

    <h:form id="form1">
    </h:form>
    <h:form id="form2">
    </h:form>
    <h:form id="form3">
        <p:commandButton onclick="submitOthers()" ></p:commandButton>
    </h:form>
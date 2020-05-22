<head>
<%
    String numVotedStr = request.getParameter("numvoted");
    int numVoted = 0;
    if (numVotedStr != null) {
        numVoted = Integer.parseInt(numVotedStr);
    }
%>
<script type="text/javascript">
    function setInterval() {
        alert("hello " + <%= numVoted %>);
    }
</script>
</head>

<body>
<form>
    <input type="button" onclick="setInterval()" value="Press Me"/>
</form>
</body>
</html>
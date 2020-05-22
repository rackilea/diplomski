<%
    String[] js = new String[16];

    for (int i=0; i<ab.length; i++) {
        js[i] = "'" + Arrays.toString(ab[i]).replace(", ", "', '") + "'";
    }

    String jsStr = Arrays.toString(js);
%>

<script lang="text/javascript">
var cArr = [
            <%= jsStr %>
            ];
</script>
<%
        int length = 3; // in your case, resultset count
        String results[] = new String[length];
        results[0] = "result1";
        results[1] = "result2";
        results[2] = "result3";

        // convert java string array to a javascript array

        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < results.length; i++) {
            sb.append("\"").append(results[i]).append("\"");
            if (i + 1 < results.length) {
                sb.append(",");
            }
        }
        sb.append("]");
        String jsarrayAsJavaString = sb.toString();
    %>
    <script language="JavaScript">
     var target = <%= jsarrayAsJavaString %>
     alert(target[0]); // target is a javascript array object. That's why you can do this
     alert(target); // print the entire javascript array

     //looping JS array
     for(var i=0;i<target.length;i++) {
         alert(target[i]); 
     }
    </script>

</body>
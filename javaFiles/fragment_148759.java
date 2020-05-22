<form name ="TutorAssign" ACTION="TutorAssign" method="post">
        <select name="labs">
        <%
        for(int i=0; i<list1.length;i++)  
        { 
        out.println("<option value="+list1[i]+"> "+list2[i]+" </option>");

        } %>
        </select>
<script>
    function showTeam() {
        var e = document.getElementById("project");
        var str = e.options[e.selectedIndex].value;
        if (str == "") {
            //if null the it'll show blank space
            document.getElementById("javaquery").innerHTML = "";
            return;
        }
        if (window.XMLHttpRequest) {
            // code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        } else {
            // code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function() {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                document.getElementById("javaquery").innerHTML = xmlhttp.responseText;
            }
        }
        xmlhttp.open("GET", "data.jsp?q=" + str);
        xmlhttp.send();

    }
</script>

<div class="menu">
    <h2>Select the Member and period</h2>
    <form>
        <table class="veryx">

            <tr>
                <td>Project</td>
                <td><select class="veryx" name="project" id="project">
                        <option>--Select--</option>
                        <jsp:scriptlet>try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager
                    .getConnection("jdbc:sqlserver://xxx.xxx.xx.xxx:1089;user=abc;password=abc;databaseName=xyz");
            PreparedStatement ps = con
                    .prepareStatement("SELECT pr_iden,pr_name FROM ip_project order by pr_name asc");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {</jsp:scriptlet>
                        <option value="<%=rs.getString(1)%>"
                            <%=(rs.getString(1).equals(session
                        .getAttribute("prjct"))) ? "selected" : ""%>>
                            <%=rs.getString(2)%></option>
                        <jsp:scriptlet>}
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }</jsp:scriptlet>
                </select></td>
                <td>
                    <button type="button" class="go" onclick="showTeam()">Go</button>
                </td>
            </tr>
        </table>
    </form>
    <div class="javaquery" id="javaquery"></div>
</div>
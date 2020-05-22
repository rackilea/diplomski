<%
    session.setAttribute("prjct", request.getParameter("q"));
%>

<form action="effort" method="post">
        <table class="veryx">
            <tfoot>
                <tr>
                    <td colspan="2" align="center" height=""><input type="submit"
                        class="veryxButton" value="Submit" /></td>
                </tr>
            </tfoot>

            <tr>
                <td>Team Member</td>
                <td><select class="veryx" name="logn">
                        <%
                            String q = request.getParameter("q");
                            try {
                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                Connection con = DriverManager
                                        .getConnection("jdbc:sqlserver://192.168.12.185:1089;user=iPlanClient;password=iPlanClient;databaseName=iPlan_VERYX");
                                PreparedStatement ps = con
                                        .prepareStatement("SELECT distinct pe_logn FROM ip_dailyeff where pr_iden="
                                                + q);
                                ResultSet rs = ps.executeQuery();
                                while (rs.next()) {
                        %>
                        <option><%=rs.getString(1)%></option>
                        <%
                            }
                        %>
                </select></td>
            </tr>
            <tr>
                <td>From</td>
                <td><input type="date" name="fromDate" /></td>
            </tr>
            <tr>
                <td>To</td>
                <td><input type="date" name="toDate" /></td>
                <jsp:scriptlet>
                con.close();
            } catch (Exception e) {
                out.println(e);
            }</jsp:scriptlet>
            </tr>
        </table>

    </form>
<%!String DisplayDate = "";%>
    <%
        String MyDate = Tools.nvl(crs.getString("indate"));
        SimpleDateFormat parseDate = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        SimpleDateFormat formatDate = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date;
        try {
            date = (Date) parseDate.parse(MyDate);
            DisplayDate = formatDate.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    %>

    <td class="td_char"><%=DisplayDate%></td>
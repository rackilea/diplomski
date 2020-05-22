<div class="release">
    <table>
        <%for (BuildStreamBean res : nm_release) {%>
        <tr  bgcolor=#ffffff>
            <td id="release" style="cursor: pointer"
                onclick="getrelease('<%=res.getId_release()%>');" onkeyup="">
                    <c:out  value="<%=res.getNm_release()%>"/>
                    <div id="<%=res.getId_release()%>"></div>
                </td>
        </tr><%}%>
    </table>                            
</div>
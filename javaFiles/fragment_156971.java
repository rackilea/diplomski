<div class ="grid">
<% 
while (rs.next()) {  // check for next row and display data accordingly
%>
  <div class="img">
        <a target="_blank" href="Selected_Game.jsp?gameid=<%=rs.getString(1)%>">
            <img src="<%=rs.getString(2)%>" alt="">
        </a>
        <div class="desc">
            <div class="GName"> 
                <%=rs.getString(3)%></div>
            <div class="Cost">Rs.<%=rs.getInt(5)%></div>
        </div>
    </div>

<% 
 }   //end of while loop
%>
</div>
<% if (Baza.getCurrentUser().loggedIn) { %>
    <a class="whiteOff" href="AdminLogin?logoff">Izloguj se (<%=k.getIme() %>)</a>
    <a class="hide" href="register.jsp">Registracija</a>
    <a class="hide" href="adminLogin.jsp">Logovanje za administratore</a>
    <a class="hide" href="userLogin.jsp">Logovanje za korisnike</a><br/>
<% } else{%>
    <a class="hide" href="AdminLogin?logoff">Izloguj se (<%=k.getIme() %>)</a>
    <a class="white" href="register.jsp">Registracija</a>
    <a class="white" href="adminLogin.jsp">Logovanje za administratore</a>
    <a class="white" href="userLogin.jsp">Logovanje za korisnike</a><br/>
<% } %>
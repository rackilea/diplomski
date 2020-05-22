public class LonginServelt extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        User user = userService.checkUserCredential(username,password);
        Session session = request.getSession();
        session.setAttribute("user",user);
    }
}

<c:choose>
  <c:when test="${isAdmin}">
    You got Gold 
  </c:when>

  <c:when test="${isCustomer}">
    You got Silver 
  </c:when>

  <c:when test="${isProducer}">
    You got Bronze 
  </c:when>

  <c:otherwise>
    Better luck next time 
  </c:otherwise>
</c:choose>
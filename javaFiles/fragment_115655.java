<form action="acceuil.jsp" name="ff" method="post">  
         <select name='mat' id='soflow'>
        <% ArrayList<Matiere> listeM = MatiereListe.GetMatiere(); %>
       <option></option>
        <% for (Matiere d : listeM)
        { %>
            <option value= <%=d.getCode_mat() %> >
                     <%=d.getLib_mat() %>
            </option>
        <% } %>
         </select>
         <input type=submit value=valider  />
        <br>
        </form>
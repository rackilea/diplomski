<c:forEach var="projet" items="${listProject}">
     <tr>
         <td><c:out value="${projet[2]}" /></td>
         <td><c:out value="${projet[1]}" /></td>
         <td><c:out value="${projet[3]}" /></td>
         <td><c:out value="${projet[4]}" /></td>
         <td><c:out value="${projet[5]}" /></td>
         <td><c:out value="${projet[6]}" /></td>
         <!-- you should include idDomaine and id_chef in your query to get them here -->
         <td><c:out value="${projet.domaine.idDomaine}" /></td>
         <td><c:out value="${projet.chefprojet.id_chef}" /></td>

    </tr>
</c:forEach>
<c:forEach var="sentence" items="${snippet.sentences}" varStatus="i">
    <tr>
      <td>${sentence.id}</td>
      <td>${sentence.text}</td>
      <td>
        <form:input type="range" 
          name="snippet.sentences[${i.index}].scale" 
          path="sentences[${i.index}].scale" 
          min="0" max="5" 
          /></td>
    </tr>
  </c:forEach>
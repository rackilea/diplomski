<c:forEach items="${specialitys}" var="speciality_subject">
        <tr>
          <td>
            <c:out value="${speciality_subject.getId()}"/>
          </td>
          <td>
            <c:out value="${speciality_subject.getProfessionSubject()}"/>
          </td>
          <td>
            <c:out value="${speciality_subject.getSubjectId()}"/>
          </td>
          <td>
            <a href="controller?command=deleteSpeciality&id=${speciality_subject.getId()}">Delete</a>
            <a href="controller?command=editSpeciality&id=${speciality_subject.getId()}">Edit</a>
          </td>
        </tr>
  </c:forEach>
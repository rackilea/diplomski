<c:forEach var="Mailer" items="${mailerlist.billerNameList}">
            <option 

<c:if check='${request.billerName eq Mailer.billerName}' >selected</c:if>

value="searchFor=${Mailer.billerName}&searchBy=3&addressTypeF=${requestScope.addressTypeF}&folder=${mailitems.mailboxAttributes.folder}"><c:out value="${Mailer.billerName}"/></option>              
            </c:forEach>
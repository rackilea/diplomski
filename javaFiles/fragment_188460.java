<c:forEach var="year1" items="${Info.list}"  varStatus="yearCounter1" >
    <c:if test="${yearCounter1.count == 1}">
        <c:forEach var="clist1" items="${year1.list}" varStatus="catCounter1">   
            <c:if test="${catCounter1.count == 1}">
                 <c:forEach var="colorlist1" items="${colorlist1.list}" varStatus="colorCounter1">
                                 <!-- this gets me to all possible colors -->
                                 <c:forEach var="year2" items="${Info.list}"  varStatus="yearCounter2" >
                    <c:forEach var="clist2" items="${tlist2.list}" varStatus="catCounter2">
                                             ....
                                                          <c:if test="${colorCounter1.description==colorCounter3.description&& year2.description==year3.description  && clist2.description==clist3.description}" >
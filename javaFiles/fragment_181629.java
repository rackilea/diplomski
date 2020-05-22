<c:forEach var="lhsSrcMap" varStatus="status" items="${lhsListMap}">  
   <c:set var="tileLhsSrcMap" value="lhsSrcMap" scope="request"/>
   <tiles:insert page="/jsp/common/lhsListing.jsp" >  

   </tiles:insert>
</c:forEach>
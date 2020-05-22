<script>
  $( function() {
  var availableTags =
      <c:forEach items="${mapList}" var="map" varStatus="totalCount">
      [         
          <c:out value="'${map.address}'">
          </c:out>
          <c:if test="${totalCount.count lt fn:length(mapList)}">
          <c:out value=",">
          </c:out>
          </c:if>      
      ];
      </c:forEach>
  $( "#tags" ).autocomplete({
    source: availableTags
  });
 } );
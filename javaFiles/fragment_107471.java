<script>
  ${groupListItem} = {}; // create object of that name
  ${groupListItem}.keys = [];
  ${groupListItem}.values = [];
  <c:forEach items="${groupListItem.checkboxMap}" var="mapItem">
      ${groupListItem}.keys.push("${mapItem.key}"); // append key
      ${groupListItem}.values.push("${mapItem.value}"); // append value
  </c:forEach>
</script>
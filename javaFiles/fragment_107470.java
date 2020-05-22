<script>
  ${groupListItem} = {}; // create object of that name
  <c:forEach items="${groupListItem.checkboxMap}" var="mapItem">
      ${groupListItem}["${mapItem.key}"] = "${mapItem.value}"; // set val
  </c:forEach>
</script>
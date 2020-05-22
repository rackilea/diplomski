function initialize() {
    var title = "";
    <c:foreach var="marker" list="${markers}">
         title = title + "${marker.street}";
    </c:foreach>
}
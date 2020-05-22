<script>
    var sliderLinks = new Array();
    <c:forEach items="${items}" var="item">
        sliderLinks.push(${item.value});
    </c:forEach>
</script>
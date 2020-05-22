<logic:iterate name="collections" id="curElement">
    <c:if test="${curElement.indexId == ${fn:length(collections) - 1}}">
        <!-- It is pretty messy ...but you get the idea -->
        <!-- We are the last element...whoohoo!!! -->
    </c:if>
</logic:iterate>
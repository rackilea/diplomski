`<c:forEach items="${objects}" var="entry">
        Key is ${entry.key} <%-- these two for testing purposes --%>
        <ul>
            <li>${entry.value.getFlightNumber()}</li>
            <li>${entry.value.getOperator()}</li>
            <li>${entry.value.getSource()}</li>

        </ul>
</c:forEach>`
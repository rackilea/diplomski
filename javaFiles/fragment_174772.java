<script>
    var reminders = []; //create a new array global
    <c:forEach items="${reminders}" var="reminder">
        reminders.push({start: "${reminder.startDate}", end: "${reminder.endDate}"});
    </c:forEach>
</script>
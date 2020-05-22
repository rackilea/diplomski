public Multimap<String, Map<String, String>> listMysqlBackups(int howManyDays) {
    // ...
}

public Map<String, Collection<Map<String, String>>> getListMysqlBackupsAsMap() {
    return listMysqlBackups(this.numberOfDays).asMap();
}


<c:forEach var="backup" items="${bean.listMysqlBackupsAsMap}">
    <c:set var="dateISO" value="${backup.key}/>
    <c:set var="backupJobs" value="${backup.value}/> <!-- a Collection<Map<String,String>> -->
    <c:forEach var="backupJob" items="${backupJobs}">
        <!-- do something with each backup job (Map<String, String>) for the current date -->
    </c:forEach>
</c:forEach>
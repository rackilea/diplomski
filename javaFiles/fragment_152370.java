<div th:each="evnt, intr : ${eventsInList.getEvents()}">
   <div class="modal fade" th:id="'modal-' + ${evnt.getId()}">
     // some content
      <form th:action="@{/updateEvent}" th:object="${eventsInList[__${intr.index}__]}" method="POST">
         <input type="text"
                th:value="${eventsInList[__${intr.index}__].getDate()}"
                th:name="|date|">
      </form>
   </div>
</div>
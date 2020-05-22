<c:forEach items="${addRatingExceptionForm.ratingsMap[addRatingExceptionForm.ratingElementDropdown]}" var="item"> 
  <li>
    <input type="checkbox" id="addRatingException_timeline_earlyAsn" value="${item.RatingInstanceValue}" class="ajaxContentTrigger method_Load_exceptionType ajaxLoadingTrigger|addRatingException_exceptionType clearErrors" />
    <label for="addRatingException_timeline_earlyAsn">${item.RatingInstanceValue}</p></label> <!-- wtf is that </p> doing there? -->
  </li>
</c:forEach>
<c:forEach var='post' items=${listOfPosts} >
   <c:set var="attribute1" value=${post.attribute1} />
   <c:set var="attribute2" value=${post.attribute2} />
   <input type="hidden" id="postXXXattribute1" value="${attribute1}" />
   <input type="hidden" id="postXXXattribute2" value="${attribute2}" />
</c:forEach>
<c:foreach items="${vectors name}" var="pos" >
       <!-- print the value of myInt for each position of the array. 
            Method getMyInt() must exist in pos object.-->
       <c:out value="${pos.myInt}"/>

       <!-- print the value of myInt for each composed instance.
            Method getRelatedInstance() must exist in pos object.  -->
       <c:out value="${pos.relatedInstance.myInt}"/>
</c:foreach>
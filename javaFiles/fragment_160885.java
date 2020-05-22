<div class="col-md-4">
    <c:forEach begin="0" end="${fn:length(names)/3}" var="name" items="${names}" varStatus="loop">
        ${name}<br/>
    </c:forEach>
</div>
<div class="col-md-4">
    <c:forEach begin="${(fn:length(names)/3) + 1}" end="${(fn:length(staffs)/3)*2}" var="name" items="${names}" varStatus="loop">
        ${name}<br/>
    </c:forEach>
</div>
<div class="col-md-4">
    <c:forEach begin="${((fn:length(names)/3)*2)+1}" var="name" items="${names}" varStatus="loop">
        ${name}<br/>
    </c:forEach>
</div>
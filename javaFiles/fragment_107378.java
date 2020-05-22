<form action="${ pageContext.request.contextPath }/customer/add" method="post">
<div>
    <label>Name: </label>
    <input type="text" name="name">
</div>
<div>
    <label>Address: </label>
    <input type="text" name="aName">    // see the change here...
</div>
<input type="submit" value="Insert">
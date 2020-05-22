<sf:form method="post"
    action="${pageContext.request.contextPath}/createproduct" modelAttribute="newProduct">

 Product
    <sf:input path="name"/>
 Category
    <sf:select path="category.idcategory">
      <sf:option value="0" label="Select a Category"></sf:option>
      <sf:options items="${categories}" itemValue="idcategory" 
                    itemLabel="name" />
    </sf:select>
      <input value="Save" type="submit" />
</sf:form>
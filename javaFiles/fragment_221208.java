<%
Map<String, List<String>> myMap = new LinkedHashMap<String,List<String>>();
request.setAttribute("mainMenu", myMap);
List<String> adminItemsList = new ArrayList<String>();
adminItemsList.add("User Creation");
adminItemsList.add("Branch Creation");

List<String> lookupItemsList = new ArrayList<String>();
lookupItemsList.add("Country");
lookupItemsList.add("Language");

myMap.put("Administrator", adminItemsList);
myMap.put("Lookup Configuration", lookupItemsList);
%>

<c:forEach items="${mainMenu}" var="myMenu">
    <li id="lookup" class="mail"><a href="#lookup">${myMenu.key}<span>26</span></a>   
    <ul class="sub-menu">
    <c:forEach items="${myMenu.value}" var="item" varStatus="loop">
         <li><a href="#"><em>02</em>_${item}_<span>14</span></a></li>
    </c:forEach>                                            
    </ul>                   
    </li>
</c:forEach>
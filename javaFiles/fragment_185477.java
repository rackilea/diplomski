<ul id="friends_list">
    <c:forEach var="item" items="${friendsList}">
        <li class="friend_item">
         <img class="friend_list_image" src="${item.friendImage}" alt="friend_image"/>
         <label>${item.friendname}</label>
         <img class="message_icon" src="Images/Message.png" alt="Message_Icon" title="Message" onclick="message_friend()"/>
        </li>
    </c:forEach>
</ul>
<c:forEach var="j" items="${files}">
    <tr>
        <td>
            <img src="resources/images/icons/${j.getIcon()}" class="file-icon" id="file-icon">
        </td>
        <td>${j.getFile()}</td>
        <td>${j.getLastmodified()}</td>
        <td>
            <a onclick="renameFileModal(${j.getFileid()})" class="rename">
                <img src="resources/images/icons/rename.svg" class="rename-icon">
            </a>

            <a onclick="deleteFileModal(${j.getFileid()})" class="delete">
                <img src="resources/images/icons/delete.svg" class="delete-icon">
            </a>

            <a href="" class="download" download="${j.getFilename()}"> 
                <img src="resources/images/icons/download.svg" class="download-icon">
                </a>
                <a>
                    <img src="resources/images/icons/share.svg" class="share-icon">
                </a>
        </td>
    </tr>           
</c:forEach>
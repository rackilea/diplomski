<table>
    <ui:repeat value="#{profile.pictures}" var="picture" varStatus="loop">
        <tr>
            <td>Upload Picture #{loop.index + 1}</td>
            <td><t:inputFileUpload value="#{picture.file}" /></td>
        </tr>
        <tr>
            <td>Description #{loop.index + 1}</td>
            <td><h:inputText value="#{picture.description}" /></td>
        </tr>
    </ui:repeat>
</table>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Test File Upload</title>
    </head>
    <body>
        <h1>Select a file to upload</h1>
        <c:if test="${not empty errors}">
            <h2 style="color:red;">${errors}.</h2>
        </c:if>
        <form:form modelAttribute="uploadedFile" method="post" enctype="multipart/form-data" name="uploadedFileform" id="uploadedFileform">
            <table width="600" border="0" align="left" cellpadding="0" cellspacing="0" id="pdf_upload_form">
                <tr>
                    <td width="180"><label class="title">Title:</label></td>
                    <td width="420"><form:input id="title" path="title" cssClass="areaInput" size="30" maxlength="128"/></td>
                </tr>
                <tr>
                    <td width="180"><label class="title">File:</label></td>
                    <td width="420"><form:input id="fileData" path="fileData" type="file" /></td>
                 </tr>
                 <tr>
                    <td width="180"></td>
                    <td width="420"><input type="submit" value="Upload File" /></td>
                 </tr>
            </table>
        </form:form>
    </body>
</html>
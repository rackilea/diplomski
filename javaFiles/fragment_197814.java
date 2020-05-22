<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" enctype="multipart/form-data"
              action="/FileUpload_2/web/upload">
            File to upload: <input type="file" name="upfile"><br/>
            Notes about the file: <input type="text" name="note"><br/>
            <br/>
            <input type="submit" value="Press"> to upload the file!
        </form>

    </body>
</html>
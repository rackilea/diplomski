<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add text to text area and submit</title>
<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

<!-- include summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.js"></script>
<body>
    <div id="summernote">Hello Summernote</div>
    <script>
        $(document).ready(function() {
            $('#summernote').summernote();

            // copy the html-text from summernote to the hidden textarea
            // and let the browser submit it
            $('#myForm').submit(function() {
                $('textarea[name=summerNoteText]').val($('#summernote').summernote('code'));
            });
        }); 
    </script>
    <!-- use method post, because method get has limits of the max length -->
    <form action="Test" method="post" id="myForm">
        <!-- add a hidden textarea, wher the summernote code will be writen on submit -->
        <textarea name="summerNoteText" style="display:none;"></textarea>
        <input type="submit"/>
    </form>
</body>
</html>
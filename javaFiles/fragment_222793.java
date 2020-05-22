<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <style type="text/css">
    .newpage{page-break-before:always}

    @page {@bottom-center {content: element(footer)}}
    #footer {position: running(footer);}

    @page last {@bottom-center {content: element(lastfooter)}}
    #lastfooter{position: running(lastfooter);}
    #lastpage  {page:last}
}
 </style>
</head>
    <body>  
        <div id="footer">Footer page 1 and 2</div>
        <div id="lastfooter">Footer for last page</div>

        <div>Page 1 content</div>
        <div class="newpage">Page 2 content</div>
        <div id="lastpage">Page 3 content</div>
    </body>
</html>
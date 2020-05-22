<html>
    <head>
    <script>
        function myFunction() {
            var r = confirm("Are you sure about that ?");
            if (r == true) {
                return 1;
            } else {
                return 2;
            }
        }
        document.getElementById('onay').value = myFunction();

    </script>
    </head>
    <body onload="javascript: myFunction()">
    <form name"frm1" id="frm1" action="servletname">
        <input type="hidden" id="onay" name="onay" />
    <input type="submit"/>
    </form>
    </body>

    </html>
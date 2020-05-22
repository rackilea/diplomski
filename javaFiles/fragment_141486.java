<html>
    <head>
        <script>
            window.onerror = function(e) {
                document.getElementById("hidden-selenium-log").innerText += e.toString() + ";";
            }
        </script>
    </head>
    <body>

        <div id="hidden-selenium-log" style="display: none;">
        </div>

        <div id="broken-button" onclick="unknownFunction()">broken</div>

    </body>
</html>
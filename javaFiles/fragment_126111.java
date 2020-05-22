<html>
<style>
h1 {
    color: green;
    background-color: black;
}
p {
    color: gray;
    background-color: black;
}
div {
    color: gray;
    background-color: black;
}
body {
    color: gray;
    background-color: black;
}
</style>

<head>
<script src="file///jquery-1.8.2.min.js"></script>

<script>
    // tail effect
    function tailScroll() {
        if (document.getElementById("auto-scroll").checked) {
            var height = $("#log-container").get(0).scrollHeight;
            $("#log-container").animate({
                scrollTop: height
            }, 500);
        }


    }

    var auto_refresh_log = setInterval(
        function() {
            var statusDiv = document.getElementById("status");
            if (statusDiv.innerHTML.indexOf("Idle.") < 0) {
                $.get("log",
                    function(data, status) {
                        if (data) {
                            var logDiv = document.getElementById("log");
                            $("#log").append(data);
                            tailScroll();
                        };
                        }
                )
            }


        }, 500
    );


    var auto_refresh_status = setInterval(
        function() {
            $('#status').load("status").fadeIn("slow");
        }, 500);



    $(document).ready(function() {
        $('#suites').load("suites").fadeIn("slow");
        $('#status').load("status").fadeIn("slow");
        $('#war-info').load("war-info").fadeIn("slow");
        $('#log').load("log").fadeIn("slow");
        $('#build').load("build").fadeIn("slow");
        $("#results").hide();
        document.getElementById("auto-scroll").checked = true;
    });

    function getSuites() {
        $('#suites').load("suites").fadeIn("slow");
    }

    function runSuites() {
        //clearLog();
        var collection = document.getElementById("suites").getElementsByTagName('INPUT');
        var suiteList = "";
        for (var x = 0; x < collection.length; x++) {
            if (collection[x].type.toUpperCase() == 'CHECKBOX')
                if (collection[x].checked) {
                    suiteList = suiteList + " " + collection[x].id;
                }
        }
        //if no suite selected don't send 
        if (suiteList) {
            $.get("/get?tcl=" + suiteList.substring(1));
        }
    }

    function execute() {
        var text = $('textarea#gtester').val();
        //if no suite selected don't send 
        if (text) {
            $.get("/get?tcl=" + text);
            $('textarea#gtester').val('');
        }
    }

    function clearLog() {
        var logDiv = document.getElementById("log");
        logDiv.innerHTML = "";
    }

    function restartServer() {
        $.get("restart");
        window.location.reload(1);
    }

    function restartSolr() {
        $.get("restart-solr");
    }

    function restartSonar() {
        $.get("restart-sonar");
    }

    function pause() {
        $.get("pause");
    }

    function abort() {
        $.get("abort");
    }

    $("form#data").submit(function() {

        var formData = new FormData($(this)[0]);



        $.ajax({
            url: window.location.pathname,
            type: 'POST',
            data: formData,
            async: false,
            success: function(data) {
                alert(data)
            },
            cache: false,
            contentType: false,
            processData: false
        });

        return false;
    });

    function selectAll(cb){
        var collection = document.getElementById("suites").getElementsByTagName('INPUT');
        for (var x=0; x<collection.length; x++) {
                if (collection[x].type.toUpperCase()=='CHECKBOX')
                collection[x].checked = cb.checked;
        }
    }

    function toggleLog(){
        if ($('#log').is(':visible')) {   
             $('#log').hide();
             $('#results').show();
        }else{
            $('#log').show();    
            $('#results').hide();
        }
    }
</script>



</head>

<body >
<dev id="build" style="float:right;">   </dev>
<h1>Remote Test Service</h1>




<dev>

    <dev>
        <!--<button id="get-suites" onclick="getSuites()">Get latest suite list</button> -->
        <button id="run-suites" onclick="runSuites()" style="background: lightgreen; ">Run Tests</button>
        <button id="pause" onclick="pause()">Pause Test</button>
        <button id="abort" onclick="abort()">Abort Test</button> 
    </dev>



    <dev style="float=right">
        <button id="restart-test" onclick="restartServer()">Restart Test Server</button>
        <button id="restart-solr" onclick="restartSolr()">Restart Solr Server</button>
        <button id="restart-sonar" onclick="restartSonar()" >Restart Sonar Service</button>
    </dev>


     <h3>
     <b>Status:</b> 
     <dev id="status" > 

     </dev> 
     </h3>





</dev>




<dev id="main" >


    <dev style="width: 30%; float:left; height: 80%;  overflow: auto;">


        <dev>
            <hr>
          <h2>Banana Tests: </h2> 
          <input type="checkbox" id="selectAll" onclick='selectAll(this);'>Select All <br>     </input>    
        </dev>

        <hr>
        <dev id="suites" style="overflow-y: auto; white-space: nowrap;">

        </dev>


        <hr>

        <h3>WAR file Upload: </h3>
        <form id="datafiles" method="post" enctype="multipart/form-data">
            <input name="warfile" type="file" />
            <!-- <input type="text" name="Description" value="WAR file description..."  /> !-->
            <button>Submit</button>
        </form>
        <dev>
            <h3> <a href="file///D:/solr-4.8.1/searchlogs/webapps/banana.war" download>Download current War file</a></h3>
            <hr>
            <dev>
                <h3>Current WAR file info: </h3> </dev>
            <dev id="war-info"> </dev>
        </dev>
        <hr>
        <dev>
            <h3>
        <b>GTester Console:</b> <button id="execute" onclick="execute()">Execute</button>
        </h3>

            <textarea id="gtester" cols="50" rows="1" onkeydown="if (event.keyCode == 13) { execute(); return false; }">

            </textarea>


        </dev>
    </dev>

    <dev id="log-super-container" style="width: 70%; float:right; height: 80%;  overflow-y:auto; overflow-x:auto; white-space: nowrap;">
        <dev style="float:left;">
           <button id="clear-log" onclick="clearLog()" >Clear log</button>  
           <button id="toggle-log" onclick="toggleLog()" >Log/TCs state</button>
           <input type="checkbox" id="auto-scroll" >Auto scroll <br> </input>          
        </dev>
        <dev style="float:left;">

        </dev>



        <dev id="log-container" style="width: 100%; height: 95%; float:right; overflow:auto; ">
            <dev id="log" style="overflow: auto; white-space: nowrap;">

            </dev>
            <dev id="results" style="overflow: auto; white-space: nowrap;">
                <h3>Passed:<br></h3>
                <dev id="passed"> 
                    0
                </dev>
                <h3>Current:<br></h3>    
                <dev id="current"> 
                    0
                </dev>
                <h3>Failed:<br></h3>
                <dev id="failed"> 
                    0
                </dev>

            </dev>

        </dev>


    </dev>




</dev>


</body>

</html>
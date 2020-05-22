<html>
<head>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap-responsive.css" rel="stylesheet">

<script>
    function rowDoubleClicked(e){
    if(document.selection && document.selection.empty) {
       document.selection.empty();
    } 
    else if(window.getSelection) {
         var selection = window.getSelection();
         selection.removeAllRanges();
    }
    $('#myTabs a[href="#system-check-in"]').tab('show');

}
</script>

 </head>
<body>
<div class="tabbable tabbable-custom">
    <ul id="myTabs" class="nav nav-tabs">
    <li class="active"><a href = "#jobs" data-toggle="tab" onclick="disabled()">Jobs</a></li>
        <li><a href="#system-check-in" data-toggle="tab" onclick="enablebtn()">System Check-in</a></li>
        <li><a href="#service-and-repair" data-toggle="tab" onclick="enablebtn()">Service & Repair</a></li>
        <li><a href="#system-check-out" data-toggle="tab" onclick="enablebtn()">System Check-out</a></li>
    </ul>
<div class="tab-content">

    <div class="tab-pane active" id="jobs" data-tabs="tabs">

            <div class="portlet box purple">
                <div class="portlet-title">
                    <h4><i class="icon-book"></i>Jobs List</h4>
                    <div class="tools">
                        <a href="javascript:;" class="collapse"></a>
                        <a href="javascript:;" class="reload"></a>
                        <a href="javascript:;" class="remove"></a>
                    </div>
                </div>
                <div class="portlet-body">
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>JOB NO</th>
                                <th>CILENT NAME</th>
                                <th>JOB DATE</th>
                                <th >DUE DATE</th>
                                <th>COMPL DATE</th>
                                <th>SYS. OUT DATE</th>
                                <th>STATUS</th>
                                <th>PRIORITY</th>
                                <th>ALLOC TO</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr ondblclick="rowDoubleClicked(event);">
                                <td>1</td>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td class="hidden-480">makr124</td>
                                <td><span class="label label-success">Approved</span></td>
                                <td>1</td>
                                <td>1</td>
                                <td>1</td>
                                <td>1</td>
                            </tr>


                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <div class="tab-pane" id="system-check-in" data-tabs="tabs">
            <p>contents related to system-check-in </p>
        </div>
    </div>
</div>
<script src="js/jquery-1.9.js" type="text/javascript"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>
</body>
</html>
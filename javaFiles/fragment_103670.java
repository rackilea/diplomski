<zk>
 <window id="HomePage" apply = "com.dom.form.ChartForm" border="none" width="100%" height="100%" style="background-color:green">
    <div id="piechart_3d" style="width: 500px; height: 300px;">
    <!-- <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script> -->
    <script type="text/javascript">
        var dataJson;
        var data = [];

        function getData(jsonObj){
            dataJson = JSON.parse(jsonObj);

            var header = ['Task Name','Hours'];
            data.push(header);  

            for(var i = 0; i &lt; dataJson.length; i++){
                var temp = [];
                temp.push(dataJson[i].taskName);
                temp.push(dataJson[i].hours);

                data.push(temp);
            }

            return data;
        }

        google.charts.load("current", {packages:["corechart"]});
        google.charts.setOnLoadCallback(drawChart);

        function drawChart(){

            var chartdata = new google.visualization.arrayToDataTable(data);

            var options = {
                title: 'My Daily Work Activities',
                is3D: true,
            };

            var chart = new google.visualization.PieChart(zk.Widget.$("$piechart_3d").$n());
            chart.draw(chartdata, options);

        }    
    </script> 
    </div>
  </window>
</zk>
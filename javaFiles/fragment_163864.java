google.load("visualization", "1", {
  callback: drawChart,
  packages:["motionchart"]
});
function drawChart() {
  var data = new google.visualization.DataTable();
  data.addColumn('string', 'Product');
  data.addColumn('date', 'Date');
  data.addColumn('number', 'Days');
  data.addRows([
    ['Cards',new Date (1989,0,1), 120],
    ['Home Loan', new Date (1990,1,1), 67],
    ['Personal Loan', new Date (1991,2,1), 89],
    ['Cards',new Date (1990,0,1), 200],
    ['Home Loan', new Date (1991,1,1), 87],
    ['Personal Loan', new Date (1992,2,1), 140]
  ]);

  var chart = new google.visualization.MotionChart(document.getElementById('chart_div'));
  chart.draw(data, {width: 1200, height:600});
}
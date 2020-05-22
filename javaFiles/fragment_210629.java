$(xml).find('graph').each(function(){
  var points = new Array()
  var x = $(this).attr('x');
  var y = $(this).attr('y');
   points.push(x);
   points.push(parseInt(y)); //modified line!
   data.push(points);
});
// Period in extended format: Py-m-dTh:m:s
// Modifies the date passed in and returns it
function addPeriod(p, d) {
  d = d || new Date();
  var b = p.match(/\d+/g);

  d.setFullYear(d.getFullYear() + +(b[0]), d.getMonth() + +(b[1]), d.getDate() + +(b[2]));
  d.setHours(d.getHours() + +(b[3]), d.getMinutes() + +(b[4]), d.getMinutes() + +(b[5]))
  return d;
}
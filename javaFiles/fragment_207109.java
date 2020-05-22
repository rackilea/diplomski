$.getJSON('/temp/jsontest', function(data) {
   var items = [];
   for (employee in data.employees) {
       items.push(employee.fullname + '<' + employee.email + '>');
   }
   alert('Employees: ' + items.join(', '));
});
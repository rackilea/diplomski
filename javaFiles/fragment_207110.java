<script>
  $(document).ready(function() {
    $("#json-button").click(function() {
      $.getJSON('/temp/jsontest', function(data) {
        var items = [];
          for (employee in data.employees) {
            items.push(employee.fullname + '<' + employee.email + '>');
          }
          alert('Employees: ' + items.join(', '));
      });
    });
  });
</script>

<form>
    <input id="json-button" type="button" value="get me some json">
</form>
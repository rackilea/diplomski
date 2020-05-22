<script>
        $(document).ready(function () {
            $("#sel").on("change",
            function () {
                 setupTable($(this).val());
            })
        });
        function setupTable(selVal) {
            //Employee -id,firstname,lastname,email
            //Sports  - id ,sportname,count
            //Tropy   - id ,result.
            if ($.fn.DataTable.isDataTable('#example')) {
                $('#example').DataTable().destroy();
            }
            var cols = [{ 'data': 'id', 'title': 'ID' }];
            switch (selVal) {
                case "Employee":
                    cols.push({ 'data': 'firstname', 'title': 'First Name' });
                    cols.push({ 'data': 'lastname', 'title': 'Last Name' });
                    cols.push({ 'data': 'email', 'title': 'Email' });
                    break;
                case "Sports":
                    cols.push({ 'data': 'sportname', 'title': 'Sport Name' });
                    cols.push({ 'data': 'count', 'title': 'Count' });
                    break;

                case "Trophy":
                    cols.push({ 'data': 'result', 'title': 'Result' });
                    break;
                default:
                    alert("nothing selected");
                    break;
            }
            $("#example").html("");
            $("#example").DataTable({
                "columns": cols,
                "ajax": {url: "/restservice/" + selVal, dataSrc:""},
                "order": [[ 0, "asc" ]],
                "paging":false
            });
        }
    </script>

    <div>
        <select id="sel">
            <option value="0">Select Layout</option>
            <option value="Employee">id,firstname,lastname,email</option>
            <option value="Sports"> id ,sportname,count</option>
            <option value="Trophy">id ,result</option>
        </select>

</div>
    <div>
        <table id="example" class="display">
            <thead></thead>
            <tbody></tbody>
        </table>
    </div>
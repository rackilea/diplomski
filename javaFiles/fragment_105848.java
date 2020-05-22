<script>
  $(function() {
    $(".staff-id").click(function() { // attach the click event handler
      var staffId = $(this).text();
      alert(staffId); // open your new window here
    });
  });
</script>

#{list items:staffScheduleList, as:'stffSchedule'} 
    <tr id="list" align="center">
        <td></td>
        <td>${stffSchedule.scheduleDate}</td>
        <td><a class="staff-id" href="#">${stffSchedule.staffId}</a></td>
        <td>${stffSchedule.staffName}</td>
        <td>${stffSchedule.deptName}</td>
        <td></td>
        <td></td>
        <td></td>
        <td id="contactNo">${stffSchedule.contactNo}</td>
    </tr>
#{/list}
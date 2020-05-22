onclick="toggleLabel();"

<script type="text/javascript">
  function toggleLabel(){
    $.ajax("<s:url action='mainMenuLabelToggle'/>");
    document.location.reload(true);
  }
</script>
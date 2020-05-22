@urlFragment.map { f =>
  <script>
    $(function() {
      //after everything is ready, so that other mechanism will be able to use the change hash event...
      document.location.hash = "@Html(@f.hash)";
    });
  </script>
}
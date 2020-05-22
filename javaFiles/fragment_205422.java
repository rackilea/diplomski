<script>
 (function loopWaitGwtReady() {          
  setTimeout(function () {
    if (window.__gwt_activeModules)
       document.write("JS output:" + testReturn() + "<br>");
    else
       loopWaitGwtReady()
  }, 50)
 })();    
</script>
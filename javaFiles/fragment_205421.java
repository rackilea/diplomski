public static native void exportTestReturn()/*-{
  $wnd.testReturn = $entry(@com.test.client.TestCode::testReturn());
  $wnd.onLoad();
}-*/;


<script>
  function onLoad() {
    document.write("JS output:" + testReturn() + "<br>");
  }
</script>
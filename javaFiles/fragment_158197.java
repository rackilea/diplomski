public native void createChart() /*-{
    var data = {
      labels: Array.of("Mon", "Tue", "Wed", "Thu", "Fri"),
      series: Array.of(Array.of(5, 2, 4, 2, 0))
    };
    var options = {
      width: "300px",
      height: "200px"
    };
    new $wnd.Chartist.Line("#chartTest", data, options);
}-*/;
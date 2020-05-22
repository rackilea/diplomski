<script language="JavaScript">
  function validate()
  {
    var dateEntered = new Date( document.getElementById("Date") + " " + document.getElementById("Time") );
    var dateNow = new Date();

    if( dateNow - dateEntered > 1000*60*60*12 )
    {
      alert( "Date entered is too old." );
      return( false );
    }
    return( true );
  }
</script>

<form method=post action="blah.html" onsubmit="JavaScript: return( validate() );">
  <input type=text id=Date name=Date>
  <input type=text id=Time name=Time>
  <input type=submit value="Submit">
</form>
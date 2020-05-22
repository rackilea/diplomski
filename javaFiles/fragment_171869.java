import com.myproject.LoggingUtilities;

rule "MyRule"
when
   MyFact()
   eval( LoggingUtilities.logLevel != LogLevel.NONE )
then
    Log.writeOut("Some Stuff");
end
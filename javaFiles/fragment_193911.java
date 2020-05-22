<Socket name="SYSLOG" host="localhost" port="514" protocol="UDP">
  <PatternLayout
    pattern="&lt;1&gt;%d{MMM dd HH:mm:ss} ${hostName} appName: {
      &quot;host&quot;:&quot;${hostName}&quot;,
      &quot;thread&quot;:&quot;%t&quot;,
      &quot;level&quot;:&quot;%p&quot;,
      &quot;logger&quot;:&quot;%c{1}&quot;,
      &quot;line&quot;:%L,
      &quot;message&quot;:&quot;%enc{%m}&quot;,
      &quot;exception&quot;:&quot;%exception&quot;
      }%n"
  />
</Socket>
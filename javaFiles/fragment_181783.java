<script>
  var url = 'http://mywebsite.com?isFeed=true';
  if ('<%= System.getProperty("env.name") %>' === 'test') {
    url += '&env=TEST';
  }
  // etc.
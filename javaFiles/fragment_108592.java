<script>
    var attributes = {codebase:'http://my.url/my/path/to/codebase',
                      code:'my.main.Applet.class',
                      archive: 'my-archive.jar',
                      width: '800', 
                      height: '600'};
    var parameters = {java_arguments: '-Xmx256m'}; // customize per your needs
    var version = '1.5' ; // JDK version
    deployJava.runApplet(attributes, parameters, version);
</script>
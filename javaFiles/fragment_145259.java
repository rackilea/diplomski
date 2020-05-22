grant codeBase "file:/path/to/app/lib/*" {
  permission java.io.FilePermission "/path/to/app/-", "read";
  permission java.io.FilePermission "/path/to/app/data/-", "read,write,delete";
};

grant codeBase "file:/path/to/app/ext/*" {
  permission java.util.PropertyPermission "java.io.tmpdir", "read";
  permission java.io.FilePermission "${java.io.tmpdir}/myapp/-", "read,write,delete";
};
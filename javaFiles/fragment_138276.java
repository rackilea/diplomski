/* anyone can read write and execute within current working dir */
grant {
  permission java.io.FilePermission "${user.dir}", "read,write,execute";
};

grant {
  permission java.io.FilePermission "${user.dir}/*", "read,write,execute,delete";
};


/* Only code from this jar can work outside of CWD */
grant codebase "file:egPriv.jar" {
  permission java.io.FilePermission "<<ALL FILES>>", "read,write,execute,delete";
};
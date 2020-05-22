// NOTE: There are ways of limiting the permissions for the notifier using the the library.
grant codeBase "file:../lib/wrapper.jar" {
        permission java.security.AllPermission;
};

// Change *my_login_notifier.jar* to whatever LoginServiceDefer.java is as a jar.
grant codeBase "file:./*my_login_notifier.jar*" {
        permission java.security.AllPermission;
};
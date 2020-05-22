cd root_dir
javac -d mods/my.module src/module-info.java src/mypackage/MyClass.java

cd test_src
javac -d test_out --module-path ../mods;../lib/junit-platform-console-standalone.jar \
--add-modules org.junit.platform.console.standalone,my.module --patch-module my.module=. \
--add-reads my.module=org.junit.platform.console.standalone mypackage/MyClass.java
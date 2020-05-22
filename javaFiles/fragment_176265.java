cd test_src/test_out
java --module-path=../../mods;../../lib/junit-platform-console-standalone.jar \
--add-modules my.module,org.junit.platform.console.standalone \
--add-reads my.module=org.junit.platform.console.standalone \
--patch-module my.module=. \
--add-opens my.module/test=org.junit.platform.console.standalone \ 
org.junit.platform.console.ConsoleLauncher test.MyClassTest
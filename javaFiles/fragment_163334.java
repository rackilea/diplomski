Executing tasks: [clean, :app:compileDebugSources, :app:compileDebugAndroidTestSources]

Configuration on demand is an incubating feature.
:app:clean
:app:preBuild UP-TO-DATE
:app:preDebugBuild UP-TO-DATE
:app:checkDebugManifest
:app:preReleaseBuild UP-TO-DATE
:app:prepareComAndroidSupportSupportV132300Library
:app:prepareComAndroidSupportSupportV42300Library
:app:prepareDebugDependencies
:app:compileDebugAidl
:app:compileDebugRenderscript
:app:generateDebugBuildConfig
:app:generateDebugAssets UP-TO-DATE
:app:mergeDebugAssets
:app:generateDebugResValues UP-TO-DATE
:app:generateDebugResources
:app:mergeDebugResources
:app:processDebugManifest
:app:processDebugResources
:app:generateDebugSources
:app:processDebugJavaRes UP-TO-DATE
:app:compileDebugJavaWithJavac
/home/mmurphy/stuff/CommonsWare/projects/andprojector/app/src/main/java/com/commonsware/andprojector/MainActivity.java:40: error: cannot find symbol
    EventBus.getDefault().registerSticky(this);
    ^
  symbol:   variable EventBus
  location: class MainActivity
/home/mmurphy/stuff/CommonsWare/projects/andprojector/app/src/main/java/com/commonsware/andprojector/MainActivity.java:45: error: cannot find symbol
    EventBus.getDefault().unregister(this);
    ^
  symbol:   variable EventBus
  location: class MainActivity
Note: /home/mmurphy/stuff/CommonsWare/projects/andprojector/app/src/main/java/com/commonsware/andprojector/MainActivity.java uses or overrides a deprecated API.
Note: Recompile with -Xlint:deprecation for details.
2 errors

 FAILED

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':app:compileDebugJavaWithJavac'.
> Compilation failed; see the compiler error output for details.

* Try:
Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output.

BUILD FAILED

Total time: 1.971 secs
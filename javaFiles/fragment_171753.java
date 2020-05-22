package master;

import org.openide.modules.ModuleInstall;

/**
 * Manages a module's lifecycle. Remember that an installer is optional and
 * often not needed at all.
 */

public class Installer extends ModuleInstall {

 @Override
 public void close() {
  //your module shutdown
 }

 @Override
 public boolean closing() {

 // this is place for your Dialog() and return:
 //
 //        true if you want to enable close the app
 //        other return false
/*
 if you force shutdown app try LifecycleManager.getDefault().exit();
 System.exit(0) is very dummy, because it does not respect betweenmodule dependencyis

 }  
}
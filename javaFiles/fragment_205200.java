user=> (javax.swing.JOptionPane/showInputDialog parent-frame "hello")

IllegalArgumentException adding a window to a container  java.awt.Container.checkNotAWindow (Container.java:490)
user=> *e
#error {
 :cause "adding a window to a container"
 :via
 [{:type java.lang.IllegalArgumentException
   :message "adding a window to a container"
   :at [java.awt.Container checkNotAWindow "Container.java" 490]}]
 :trace
 [[java.awt.Container checkNotAWindow "Container.java" 490]
  [java.awt.Container addImpl "Container.java" 1091]
  [java.awt.Container add "Container.java" 973]
  [javax.swing.plaf.basic.BasicOptionPaneUI addMessageComponents "BasicOptionPaneUI.java" 358]
  [com.apple.laf.AquaOptionPaneUI createMessageArea "AquaOptionPaneUI.java" 92]
  [javax.swing.plaf.basic.BasicOptionPaneUI installComponents "BasicOptionPaneUI.java" 172]
  [javax.swing.plaf.basic.BasicOptionPaneUI installUI "BasicOptionPaneUI.java" 141]
  [javax.swing.JComponent setUI "JComponent.java" 666]
  [javax.swing.JOptionPane setUI "JOptionPane.java" 1860]
  [javax.swing.JOptionPane updateUI "JOptionPane.java" 1882]
  [javax.swing.JOptionPane <init> "JOptionPane.java" 1845]
  [javax.swing.JOptionPane showInputDialog "JOptionPane.java" 568]
  [javax.swing.JOptionPane showInputDialog "JOptionPane.java" 494]
  [javax.swing.JOptionPane showInputDialog "JOptionPane.java" 455]
  [user$eval10619 invokeStatic "form-init4926112649336753943.clj" 1]
  [user$eval10619 invoke "form-init4926112649336753943.clj" 1]
  ...
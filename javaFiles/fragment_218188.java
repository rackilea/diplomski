tree:generic jbevain$ svn log -c 1081190 && svn diff -c 1081190
------------------------------------------------------------------------
r1081190 | dbrosius | 2011-03-13 19:41:20 +0100 (Sun, 13 Mar 2011) | 1 line

Bug 48908 - Select instructions should implement StackConsumer instead of StackProducer
------------------------------------------------------------------------
Index: Select.java
===================================================================
--- Select.java (revision 1081189)
+++ Select.java (revision 1081190)
@@ -33,7 +33,7 @@
  * @see InstructionList
  */
 public abstract class Select extends BranchInstruction implements VariableLengthInstruction,
-        StackProducer {
+        StackConsumer {

     private static final long serialVersionUID = 2806771744559217250L;
     protected int[] match; // matches, i.e., case 1: ...
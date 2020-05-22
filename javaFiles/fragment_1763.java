package my.findbugs.detectors.forbiddencalls;

import org.apache.log4j.Logger; // it is not trivial to use a logger with FindBugs in Eclipse, leave it out if there are problems

import my.findbugs.detectors.util.DetectorUtil;

import edu.umd.cs.findbugs.BugInstance;
import edu.umd.cs.findbugs.BugReporter;
import edu.umd.cs.findbugs.bcel.OpcodeStackDetector;
import edu.umd.cs.findbugs.classfile.ClassDescriptor;
import edu.umd.cs.findbugs.classfile.FieldDescriptor;


public class CallToSystemOutPrintlnDetector2 extends OpcodeStackDetector {

    private static final Logger LOGGER = Logger.getLogger(CallToSystemOutPrintlnDetector2.class);
    private BugReporter bugReporter;


    public CallToSystemOutPrintlnDetector2(BugReporter bugReporter) {
        super();
        this.bugReporter = bugReporter;
        LOGGER.debug("Instantiated.");
    }


    public void sawOpcode(int seen) {

        // find occurrences of:  
        //2:   getstatic       #54; //Field java/lang/System.out:Ljava/io/PrintStream;
//2:   getstatic       #54; //Field java/lang/System.out:Ljava/io/PrintStream;

        if (seen == GETSTATIC){

            try {
//              LOGGER.debug(operand); // static java.lang.System.out Ljava/io/PrintStream;
//              LOGGER.debug(operand.getClass()); // class edu.umd.cs.findbugs.classfile.analysis.FieldInfo
//              LOGGER.debug(operand.getName()); // err
//              LOGGER.debug(operand.getClassDescriptor()); // java/lang/System
//              LOGGER.debug(operand.getSignature()); // Ljava/io/PrintStream;

                FieldDescriptor operand = getFieldDescriptorOperand();
                ClassDescriptor classDescriptor = operand.getClassDescriptor();
                if ("java/lang/System".equals(classDescriptor.getClassName()) && 
                        ("err".equals(operand.getName())||"out".equals(operand.getName()))) {
                    reportBug();
                }
            } catch (Exception e) {
                //ignore
            }

            // could be used
//          try {
//              MethodDescriptor operand = getMethodDescriptorOperand();
//              LOGGER.debug(operand); // java.lang.System.outLjava/io/PrintStream;
//              LOGGER.debug(operand.getClass()); // class edu.umd.cs.findbugs.classfile.MethodDescriptor
//              LOGGER.debug(operand.getName()); // err 
//              LOGGER.debug(operand.getClassDescriptor()); // java/lang/System
//              LOGGER.debug(operand.getSignature()); // Ljava/io/PrintStream;
//          } catch (Exception e) {
//              //ignore
//          }

            // could be used
//          try {
//              String operand = getRefConstantOperand();
//              LOGGER.debug(operand); // java.lang.System.out : Ljava.io.PrintStream;
//              if (operand != null && (
//                  operand.startsWith("java.lang.System.out :") || operand.startsWith("java.lang.System.err :"))) {
//                  reportBug();
//              }
//          } catch (Exception e) {
//              //ignore
//          }
        }
    }

    private void reportBug(){
        this.bugReporter.reportBug(getBugInstance());
    }


    private BugInstance getBugInstance() {
        return new BugInstance(this, "MY_CALL_TO_SYSTEM_OUT_BUG", DetectorUtil.MY_PRIORITY)
            .addClassAndMethod(this)
            .addSourceLine(this);
    }

}
import org.apache.bcel.Repository;
import org.apache.bcel.classfile.Constant;
import org.apache.bcel.classfile.ConstantFieldref;
import org.apache.bcel.classfile.ConstantNameAndType;
import org.apache.bcel.classfile.ConstantPool;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.LocalVariable;
import org.apache.bcel.classfile.LocalVariableTable;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.GETFIELD;
import org.apache.bcel.generic.Instruction;
import org.apache.bcel.generic.InstructionHandle;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.LoadInstruction;
import org.apache.bcel.generic.LocalVariableInstruction;
import org.apache.bcel.generic.MethodGen;

public class UnusedVariablesTest
{
    private int usedInt;
    private String usedString;
    private int unusedInt;
    private String unusedString;

    public static void main(String[] args) throws ClassNotFoundException
    {
        String className = "UnusedVariablesTest";
        JavaClass c = Repository.lookupClass(className);
        ConstantPool cp = c.getConstantPool();
        ConstantPoolGen cpg = new ConstantPoolGen(cp);
        for (Method m : c.getMethods())
        {
            //System.out.println("Method "+m);
            MethodGen mg = new MethodGen(m, className, cpg);
            InstructionList il = mg.getInstructionList();
            InstructionHandle[] ihs = il.getInstructionHandles();
             for(int i=0; i < ihs.length; i++) {
                InstructionHandle ih = ihs[i];
                Instruction instruction = ih.getInstruction();
                //System.out.println("    "+instruction);
                if (instruction instanceof LocalVariableInstruction)
                {
                    LocalVariableInstruction lvi = (LocalVariableInstruction)instruction;
                    LocalVariableTable lvt = m.getLocalVariableTable();
                    int index = lvi.getIndex();
                    LocalVariable lv = lvt.getLocalVariable(index, ih.getPosition());
                    if (lv != null)
                    {
                        System.out.println("Using "+lv.getName());
                    }
                }
                else if (instruction instanceof GETFIELD)
                {
                    GETFIELD getfield = (GETFIELD)instruction;
                    int index = getfield.getIndex();
                    Constant constant = cp.getConstant(index);
                    if (constant instanceof ConstantFieldref)
                    {
                        ConstantFieldref cfr = (ConstantFieldref)constant;
                        Constant constant2 = cp.getConstant(cfr.getNameAndTypeIndex());
                        if (constant2 instanceof ConstantNameAndType)
                        {
                            ConstantNameAndType cnat = (ConstantNameAndType)constant2;
                            System.out.println("Using "+cnat.getName(cp));
                        }
                    }
                }
             }
        }
    }

    void someMethod(int usedIntArgument, int unusedIntArgument)
    {
        System.out.println(usedInt+usedString+usedIntArgument);
    }
}
import com.sun.org.apache.bcel.internal.generic.*;
    ...

    Instruction.setComparator((i1, i2) -> {
        if (i1 instanceof BranchInstruction) {
            return i1 == i2;
        }
        return InstructionComparator.DEFAULT.equals(i1, i2);
    });
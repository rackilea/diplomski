import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class AssemblyChallenge {
    //Possible solutions to be confirmed.
    private static ArrayList<int[]> solutions = new ArrayList<>();

    //This is the main logic.
    public static void main(String[] args) {
        Memory memory1 = new Memory();
        Memory memory2 = new Memory();
        while (memory1.value == memory2.value) {
            memory2 = new Memory();
        }
        Register register1 = new Register();
        Register register2 = new Register();
        int startingMemoryValue1 = memory1.value;
        int startingMemoryValue2 = memory2.value;
        int startingRegisterValue1 = register1.value;
        int startingRegisterValue2 = register2.value;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        for (int m = 0; m < 8; m++) {
                            for (int n = 0; n < 8; n++) {
                                for (int o = 0; o < 8; o++) {
                                    for (int p = 0; p < 8; p++) {
                                        memory1.value = startingMemoryValue1;
                                        memory2.value = startingMemoryValue2;
                                        register1.value = startingRegisterValue1;
                                        register2.value = startingRegisterValue2;
                                        int[] instructions = new int[8];
                                        instructions[0] = i;
                                        instructions[1] = j;
                                        instructions[2] = k;
                                        instructions[3] = l;
                                        instructions[4] = m;
                                        instructions[5] = n;
                                        instructions[6] = o;
                                        instructions[7] = p;
                                        runInstructions(instructions, memory1, memory2, register1, register2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        confirmSolutions();
    }

    //This runs an set of instruction sets
    public static boolean runInstructions(int[] instructions, Memory memory1, Memory memory2, Register register1, Register register2) {
        int memoryValue1 = memory1.value;
        int numMoves = 0;
        for (int instruction : instructions) {
            numMoves++;
            switch (instruction) {
                case 0:
                    moveRegisterIntoMemory(memory1, register1);
                    break;
                case 1:
                    moveRegisterIntoMemory(memory1, register2);
                    break;
                case 2:
                    moveRegisterIntoMemory(memory2, register1);
                    break;
                case 3:
                    moveRegisterIntoMemory(memory2, register2);
                    break;
                case 4:
                    subtractMemoryFromRegister(register1, memory1);
                    break;
                case 5:
                    subtractMemoryFromRegister(register1, memory2);
                    break;
                case 6:
                    subtractMemoryFromRegister(register2, memory1);
                    break;
                case 7:
                    subtractMemoryFromRegister(register2, memory2);
                    break;
            }
            if (memoryValue1 == memory2.value) {
                int[] solution = Arrays.copyOfRange(instructions, 0, numMoves);
                if (!isSolutionAlreadyFound(solution)) {
                    solutions.add(solution);
                }
                return true;
            }
        }
        return false;
    }

    private static boolean isSolutionAlreadyFound(int[] solution) {
        for (int[] foundSolution : solutions) {
            if (Arrays.equals(solution, foundSolution)) {
                return true;
            }
        }
        return false;
    }

    private static void confirmSolutions() {
        Memory memory1 = new Memory();
        Memory memory2 = new Memory();
        while (memory1.value == memory2.value) {
            memory2 = new Memory();
        }
        Register register1 = new Register();
        Register register2 = new Register();
        int startingMemoryValue1 = memory1.value;
        int startingMemoryValue2 = memory2.value;
        int startingRegisterValue1 = register1.value;
        int startingRegisterValue2 = register2.value;
        for (int i = 0; i < solutions.size(); i++) {
            memory1.value = startingMemoryValue1;
            memory2.value = startingMemoryValue2;
            register1.value = startingRegisterValue1;
            register2.value = startingRegisterValue2;
            boolean success = runInstructions(solutions.get(i), memory1, memory2, register1, register2);
            if (success && solutions.get(i).length < 8) {
                System.out.println(Arrays.toString(solutions.get(i)) + " was successful in " + solutions.get(i).length + " moves!");
            }
        }
    }

    //This takes the value in the register and copies it into the value at the memory
    public static void moveRegisterIntoMemory(Memory memory, Register register) {
        memory.value = register.value;
    }

    //This takes the value in the memory and subtracts it from the value in the register
    public static void subtractMemoryFromRegister(Register register, Memory memory) {
        register.value -= memory.value;
    }

    //This is the Memory class which stores a random value
    static class Memory {
        public int value;

        public Memory() {
            Random random = new Random();
            value = random.nextInt(20000) - 10000;
        }
    }

    //This is the Register class which stores a random value
    static class Register {
        public int value;

        public Register() {
            Random random = new Random();
            value = random.nextInt(20000) - 10000;
        }
    }
}
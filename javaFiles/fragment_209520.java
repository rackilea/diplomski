while(true) // keep looping
{
    boolean instructionExecuted = false; // we haven't done an instruction this iteration

    // Instruction 1
    if(condition) {                         
        instructionExecuted = true;
        //do stuff
    } else {
        //do stuff
    }

    // Instruction 2
    if(condition && !instructionExecuted) {  // If we've not done an instruction,
                                             // and we can do instruction #2
        instructionExecuted = true;
        //do stuff
    } else if (!instructionExecuted) {       // only do this if we haven't already
                                             // done an instruction
        //do stuff
    }

    // Instruction 3
    if(condition && !instructionExecuted) { // If we've not done an instruction,
        instructionExecuted = true;         // and we can do instruction #3
        //do stuff
    } else if (!instructionExecuted) {      // only do this if we haven't already
                                            // done an instruction
        //do stuff
    }

    //etc.

    if(none condition)
    {
        break;
    }
}
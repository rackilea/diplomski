line += String.format("%-21s%+05d\n%-21s%6s%-21s%+05d\n%-21s%6s%-21s%6s",
                              "accumulator",accum,
                              "instructionCounter",String.format("%02d\n", instructionCounter),
                              "instructionRegister",instructionRegister,
                              "operationCode",String.format("%02d\n", operationCode),
                              "operand",String.format("%02d\n", operand) );
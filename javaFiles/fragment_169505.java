int val = pop();                // pop an int from the stack
if (val < low || val > high) {  // if its less than <low> or greater than <high>,
    pc += default;              // branch to default 
} else {                        // otherwise
    pc += table[val - low];     // branch to entry in table
}
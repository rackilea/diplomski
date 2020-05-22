public Results getResults(boolean inp1, boolean inp2)
        {
            boolean sum = x1.OperatorGate(inp1, inp2);
            boolean carry = a1.OperatorGate(inp1, inp2);
            return new Results(sum, carry);         
        }
public static void main(String args[]) {
    S s = new S();
    s.addSample(1);
    /* ... */

    ComputeMeanOperation op1 = new ComputeMeanOperation();
    CheckConvergenceOperation op2 = new CheckConvergenceOperation ();        

    // Anonymous Operation
    Op<Integer> op3 = new Op<Integer>(){
       public void Compute(List<Integer> samples){
           this.Result = samples[0]; // Gets first value of samples
       }
    }

    s.Process(op1); // Or use overloaded methods
    s.Process(op2);
    s.Process(op3);

    System.out.println("Op1 result: " + op1.Result); 
    System.out.println("Op2 result: " + op2.Result);
    System.out.println("Op3 result: " + op3.Result);
}
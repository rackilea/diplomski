public static void calculatorTight(String[] prompts, float[] vals) {
    // do calcs in printf() command
    Scanner kb = new Scanner(System.in); 
    for(int i = 0; i < prompts.length; i++){
        System.out.print(prompts[i]);
        vals[i] = kb.nextFloat();
    }
    ...
}//calculatorTight
ThreadLocal<Random> rng = new ThreadLocal<Random>(){
    @Override
    protected Random init(){
        return new Random();
    }
}; 
// afterwards...
Random r = rng.get();
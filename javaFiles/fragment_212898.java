interface Hatchery<X extends CharSequence, Y extends ConfiguredProduct<X>>{ 
       Worker<Y> breed();
    }

class WorkerHatchery implements Hatchery<String,ConfiguredProduct<String>> { 
        public Worker<ConfiguredProduct<String>> breed() {  
        return new  StringWorker();     
    }   
}
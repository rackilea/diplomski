GParsExecutorsPool.withPool() {
    Closure longLastingCalculation = {calculate()}
    Closure fastCalculation = longLastingCalculation.async()  //create a new closure, which starts the original closure on a thread pool
    Future result=fastCalculation()                           //returns almost immediately
    //do stuff while calculation performs …
    println result.get()
}
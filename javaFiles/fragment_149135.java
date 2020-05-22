class B extends A {
    def run(){
        super.run()
        println "Hello from ${this.getClass()}!"
    }
}
class MainFactory{

    protected Worker makeWorker(){
        return new Worker();
    }

    public createIntanceOfSubworker(){
       Worker i = makeWorker()
    }
}

class SubFactory extends MainFactory{
    @override
    protected SubWorker makeWorker(){
        return new SubWorker();
    }
}

class Worker{
}

class SubWorker extends Worker{
}
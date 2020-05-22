public static class Task {
    private Callable callable;
    private SubType subType;

    private Task(SubType subType) {
        System.out.println("Subtype");
        this.subType = subType;
    }
    private Task(Callable callable) {
        System.out.println("callable");
        this.callable = callable;
    }

    public static Task create ( final Callable callable )
    {
       if ( callable instance of SubTask )
       {
         return new Task( (SubType) callable );
       }

       return new Task( callable );

    }
}

public static class Factory {

    // Note that we are now calling Task's factory method
    public static Task create(Callable task) {
        System.out.println("task instanceof SubType: " + (task instanceof SubType));
        return Task.create(task);
    }
}
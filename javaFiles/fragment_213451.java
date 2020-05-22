public void registerCommandHandler<C, CH>()
        where C : new()
        where CH : new()
        where C : Command
        where CH : CommandHandler<C>
    {
        C instanceOfC = new C();
        CH instanceOfCH = new CH();
    }
// forgive my syntax errors etc., my Java has definitely gone a little rusty!

interface WorkCommand {
    public abstract void run(MyObject o1, MyObject o2);
}

...

Map<Pair<State,State>, WorkCommand> commands;
// ^ pseudo-code type for your command look-up map; type Pair<X,Y> doesn't exist,
//   so replace this with something sensible!

void doWork(MyObject o1, MyObject o2)
{
    WorkCommand worker = commands.get(new Pair<State,State>(o1, o2));
    worker.run(o1, o2);
}
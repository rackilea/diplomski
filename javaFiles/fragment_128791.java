public class Optimizer3D implements Callable<Molecule>{
    private Molecule mol3D;
    private Molecule mol2D;

    Optimizer3D(Molecule mol2D_)
    {
       this.mol2D = mol2D_; 
    }

    @Override
    public Molecule call() {
        mol3D = chemAxonOptimizer();
        return getOptimizedMol();
    }

    private Molecule chemAxonOptimizer()
    {
        //optimize molecule code not shown
        return molecule;

    }


    private Molecule getOptimizedMol()
    {
        return mol3D;
    }
}
public abstract class Generator{

    Data data;

    public Generator(Data data) {
        this.data = data;
    }

    public abstract double[][] generate();
        //here I need reference - data
    }
}

public class GeneratorA extends Generator{

    public GeneratorA(Data data) {
        super(data);
    }

    public double[][] generate(){
        //first implementation - I want to work with data
    }
}


public class GeneratorB extends Generator{

    public GeneratorB(Data data) {
        super(data);
    }

    public double[][] generate(){
    //second implementation - I want to work with data
    }
}
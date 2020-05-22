public class NrlMain {
    public void accessingInnerClass() {
        // Creating the mProgram instance
        mProgram mprogram = new mProgram();
        // Creating inner class instance
        mProgram.NrlData nrlData = mprogram.new NrlData();
    }
}
import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.*;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.*;
import com.jme3.util.BufferUtils;

public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {

        Vector3f[] lineVerticies=new Vector3f[5];

        lineVerticies[0]=new Vector3f(2,0,0);
        lineVerticies[1]=new Vector3f(-1,0,1);
        lineVerticies[2]=new Vector3f(0,1,1);
        lineVerticies[3]=new Vector3f(1,1,1);
        lineVerticies[4]=new Vector3f(1,4,0);

        plotPoints(lineVerticies,ColorRGBA.White);
    }


    public void plotPoints(Vector3f[] lineVerticies, ColorRGBA pointColor){
        Mesh mesh = new Mesh();
        mesh.setMode(Mesh.Mode.Points);


        mesh.setBuffer(VertexBuffer.Type.Position, 3, BufferUtils.createFloatBuffer(lineVerticies));


        mesh.updateBound();
        mesh.updateCounts();

        Geometry geo=new Geometry("line",mesh);
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", pointColor);
        geo.setMaterial(mat);



        rootNode.attachChild(geo);
    }


    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
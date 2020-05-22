public class TerrainGridTest extends SimpleApplication {

    private Material mat_terrain;
    private TerrainGrid terrain;
    private float grassScale = 64;
    private float dirtScale = 16;

    public static void main(final String[] args) {
        TerrainGridTest app = new TerrainGridTest();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        this.flyCam.setMoveSpeed(100f);
        initMaterial();
        initTerrain();
        this.getCamera().setLocation(new Vector3f(0, 200, 0));
        this.getCamera().lookAt(new Vector3f(0,0,0), Vector3f.UNIT_Y);
        this.viewPort.setBackgroundColor(new ColorRGBA(0.7f, 0.8f, 1f, 1f));
        initLight();
    }

    @Override
    public void simpleUpdate(final float tpf) {

    }

    public void initMaterial() {
        // TERRAIN TEXTURE material
        this.mat_terrain = new Material(this.assetManager, "Common/MatDefs/Terrain/HeightBasedTerrain.j3md");


        // GRASS texture
        Texture grass = this.assetManager.loadTexture("Textures/white.png");
        grass.setWrap(WrapMode.Repeat);
        this.mat_terrain.setTexture("region1ColorMap", grass);
        this.mat_terrain.setVector3("region1", new Vector3f(-10, 0, this.grassScale));

        // DIRT texture
        Texture dirt = this.assetManager.loadTexture("Textures/white.png");
        dirt.setWrap(WrapMode.Repeat);
        this.mat_terrain.setTexture("region2ColorMap", dirt);
        this.mat_terrain.setVector3("region2", new Vector3f(0, 900, this.dirtScale));

        // ROCK texture
        //Texture rock = this.assetManager.loadTexture("Textures/Terrain/Rock2/rock.jpg");
        Texture building = this.assetManager.loadTexture("Textures/building.png");
        building.setWrap(WrapMode.Repeat);


        this.mat_terrain.setTexture("slopeColorMap", building);
        this.mat_terrain.setFloat("slopeTileFactor", 32);

        this.mat_terrain.setFloat("terrainSize", 513);
    }

    private void initLight() {
        DirectionalLight light = new DirectionalLight();
        light.setDirection((new Vector3f(-0.5f, -1f, -0.5f)).normalize());
        rootNode.addLight(light);
    }

    private void initTerrain() {
        this.terrain = new TerrainGrid("terrain", 65, 257, new ImageTileLoader(assetManager, new Namer() {

            public String getName(int x, int y) {
               //return "Interface/Scenes/TerrainMountains/terrain_" + x + "_" + y + ".png";
                return "Textures/heightmap.png";
            }
        }));

        this.terrain.setMaterial(mat_terrain);
        this.terrain.setLocalTranslation(0, 0, 0);
        this.terrain.setLocalScale(3f, 1.5f, 3f);
        this.rootNode.attachChild(this.terrain);

        TerrainLodControl control = new TerrainGridLodControl(this.terrain, getCamera());
        control.setLodCalculator( new DistanceLodCalculator(65, 2.7f) ); // patch size, and a multiplier
        this.terrain.addControl(control);
    }
}
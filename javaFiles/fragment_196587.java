package examples;

    import javax.media.j3d.Alpha;
    import javax.media.j3d.AmbientLight;
    import javax.media.j3d.Appearance;
    import javax.media.j3d.BoundingSphere;
    import javax.media.j3d.Bounds;
    import javax.media.j3d.BranchGroup;
    import javax.media.j3d.DirectionalLight;
    import javax.media.j3d.GeometryArray;
    import javax.media.j3d.IndexedTriangleArray;
    import javax.media.j3d.Node;
    import javax.media.j3d.PolygonAttributes;
    import javax.media.j3d.RotationInterpolator;
    import javax.media.j3d.Shape3D;
    import javax.media.j3d.Transform3D;
    import javax.media.j3d.TransformGroup;
    import javax.media.j3d.View;
    import javax.media.j3d.ViewPlatform;
    import javax.vecmath.Color3f;
    import javax.vecmath.Point3d;
    import javax.vecmath.Vector3f;

    import com.sun.j3d.utils.geometry.GeometryInfo;
    import com.sun.j3d.utils.geometry.NormalGenerator;
    import com.sun.j3d.utils.universe.MultiTransformGroup;
    import com.sun.j3d.utils.universe.SimpleUniverse;
    import com.sun.j3d.utils.universe.ViewingPlatform;

    public class Example {

      public static void main(final String[] args) {
        new Example();
      }

      public Example() {
        final SimpleUniverse universe = new SimpleUniverse();

        final BranchGroup group = new BranchGroup();
        final TransformGroup tg = new TransformGroup();
        final BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);
        final Node blob = createMonster();
        { //to enable rotation
          tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
          tg.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        }
        // Create rotation to see all sides of the object
        final Transform3D btrans = new Transform3D();
        btrans.rotX(1);
        final Transform3D ztrans = new Transform3D();
        ztrans.rotZ(-1);
        btrans.mul(ztrans);
        final RotationInterpolator ri = createRotation(tg, bounds, btrans, 7000);
        tg.addChild(ri);
        tg.addChild(blob);
        //
        group.addChild(tg);
        //
        addLight(group, new Color3f(1f, 1f, 0f), new Vector3f(4.0f, +7.0f, -12.0f));
        addLight(group, new Color3f(1f, 1f, 1f));
        //
        final ViewingPlatform viewingPlatform = universe.getViewingPlatform();
        final ViewPlatform view = viewingPlatform.getViewPlatform();
        view.setViewAttachPolicy(View.NOMINAL_SCREEN);
        viewingPlatform.setNominalViewingTransform();

        final MultiTransformGroup mtg = viewingPlatform.getMultiTransformGroup();
        final TransformGroup vtg = mtg.getTransformGroup(0);
        final Transform3D t1 = btrans;
        vtg.getTransform(t1);
        t1.setScale(2);
        vtg.setTransform(t1);
        group.compile();
        // add the group of objects to the Universe
        universe.addBranchGraph(group);

      }

      private Node createMonster() {
        final Shape3D child = createShape();
        final Appearance fillAppNode = new Appearance();
        final PolygonAttributes pAtt = new PolygonAttributes();
        // avoid trouble with clockwise faces
        pAtt.setCullFace(PolygonAttributes.CULL_NONE);
        pAtt.setBackFaceNormalFlip(true);
        fillAppNode.setPolygonAttributes(pAtt);
        child.setAppearance(fillAppNode);

        return child;
      }

      private Shape3D createShape() {
        final Point3d[] points = new Point3d[] {//
        new Point3d(-1, 1, 0), //
            new Point3d(1, 1, 0), //
            new Point3d(1, -1, 0), //
            new Point3d(-1, -1, 0), //
            new Point3d(0, 0, 1), //
        };
        final int[] idxs = new int[] {// the triangle faces
        0, 1, 2,//
            2, 3, 0,//
            1, 0, 4,//
            1, 2, 4,//
            2, 3, 4,//
            3, 0, 4 };
        final IndexedTriangleArray ita = new IndexedTriangleArray(points.length, GeometryArray.COORDINATES
            | GeometryArray.COLOR_3, idxs.length);
        ita.setCoordinates(0, points);
        ita.setCoordinateIndices(0, idxs);
        //per vertex colors really are per vertex reference
        //so each vertex can have a different color for each of its faces
        final Color3f[] colors = new Color3f[] {//
        new Color3f(1, 0, 1),//
            new Color3f(0, 1, 0),//
            new Color3f(0, 0, 1),//
            new Color3f(1, 1, 0),//
            new Color3f(1, 1, 1),//
        };
        ita.setColors(0, colors);
        ita.setColorIndices(0, idxs);
        ita.setColorIndices(0, new int[] { 0, 0, 0, 1, 1, 1 });
        //
        final GeometryInfo gi = new GeometryInfo(ita);
        //also generate normal vectors so that the surface can be light
        final NormalGenerator normalGenerator = new NormalGenerator();
        normalGenerator.generateNormals(gi);

        final GeometryArray geometryArray = gi.getGeometryArray();
        return new Shape3D(geometryArray);
      }

      private RotationInterpolator createRotation(final TransformGroup objScale, final Bounds bounds,
          final Transform3D btrans, final long milis) {
        final Alpha alpha = new Alpha(-1, Alpha.INCREASING_ENABLE, 0, 0, milis, 0, 0, 0, 0, 0);

        final RotationInterpolator ri = new RotationInterpolator(alpha, objScale, btrans, 0.0f, (float) Math.PI * 2.0f);
        ri.setSchedulingBounds(bounds);
        return ri;
      }

      private void addLight(final BranchGroup group, final Color3f light1Color, final Vector3f ligthDirection) {
        {
          final BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);
          final DirectionalLight light1 = new DirectionalLight(light1Color, ligthDirection);
          light1.setInfluencingBounds(bounds);
          group.addChild(light1);
        }
      }

      private void addLight(final BranchGroup group, final Color3f light1Color) {
        {
          final BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);
          final AmbientLight light1 = new AmbientLight(light1Color);
          light1.setInfluencingBounds(bounds);
          group.addChild(light1);
        }
      }
    }
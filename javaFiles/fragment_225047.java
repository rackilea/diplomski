package Earth;

import gov.nasa.worldwind.*;
import gov.nasa.worldwind.avlist.AVKey;
import gov.nasa.worldwind.awt.WorldWindowGLCanvas;
import java.awt.BorderLayout;

import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;

import gov.nasa.worldwind.layers.*;
import gov.nasa.worldwind.layers.Earth.*;
import java.awt.Dimension;
import javax.swing.JInternalFrame;

@TopComponent.Description(
        preferredID = "EarthTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "explorer", openAtStartup = false)
@ActionID(category = "Window", id = "Earth.EarthTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_EarthAction",
        preferredID = "EarthTopComponent"
)
@Messages({
    "CTL_EarthAction=Earth",
    "CTL_EarthTopComponent=Earth Window",
    "HINT_EarthTopComponent=This is the Earth window"
})
public final class EarthTopComponent extends TopComponent {

    public EarthTopComponent() {
        initcomp();
        setName(Bundle.CTL_EarthTopComponent());
        setToolTipText(Bundle.HINT_EarthTopComponent());

    }

    private LayerList layerlist;  //Holds all Layers
    private WorldWindowGLCanvas canvas;     //Displays Model
    private Model model;      //world and layers
    private OptionSideBar sidebar; 
    private JInternalFrame layersPanel;

    private void initcomp()
    {
        canvas = new WorldWindowGLCanvas();
        sidebar = new OptionSideBar();

        //Creates a new model to display in the canvas
        model = (Model) WorldWind.createConfigurationComponent(AVKey.MODEL_CLASS_NAME);

        loadLayers();

        //adds all relevant layers to the model
        model.setLayers(layerlist);

        //adds the model to the canvas
        canvas.setModel(model);

        setLayout(new BorderLayout());

        layersPanel = new JInternalFrame("Layers Panel");
        layersPanel.setIconifiable(true);

        layersPanel.setSize(new Dimension(150,250 ));
        layersPanel.add(sidebar.getSideBar());
        layersPanel.setVisible(true);     

        setLayout(new BorderLayout());
        canvas.setSize(new Dimension(500,550));
        canvas.setVisible(true);

        add(layersPanel,BorderLayout.CENTER);
        add(canvas,BorderLayout.CENTER);
    }

     /**
     * Adds relevant layers to layerlist to be added to the model
     */
    private void loadLayers()
    {
        //creates a new layerlist array
        layerlist = new LayerList();

        //preloading all of the default layers
        layerlist.add(new StarsLayer());            //Stars
        layerlist.add(new SkyGradientLayer());      //Atmosphere
        layerlist.add(new BMNGWMSLayer());          //BlueMarble Globe
        layerlist.add(new CountryBoundariesLayer());//Political Boundaries
        layerlist.add(new MSVirtualEarthLayer());   //City View
        layerlist.add(new NASAWFSPlaceNameLayer()); //Names of Places
        layerlist.add(new LatLonGraticuleLayer());  //Lat and Long Grid        
    }
}
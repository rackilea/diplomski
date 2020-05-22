package spike;

import java.util.ArrayList;
import java.util.List;

import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.geotools.geometry.jts.GeometryBuilder;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;

import com.vividsolutions.jts.geom.Point;

public class ShpFileBuilder {
    static final GeometryBuilder GEOMBUILDER = new GeometryBuilder();

    public SimpleFeatureType buildType(PointDTO dto) {
        SimpleFeatureTypeBuilder builder = new SimpleFeatureTypeBuilder();
        builder.setName(dto.type);
        builder.setNamespaceURI("http://www.geotools.org/");
        builder.setSRS("EPSG:25829");
        builder.add("the_geom", Point.class);
        for (String[] att : dto.atributtes) {
            builder.add(att[0], String.class);
        }
        SimpleFeatureType featureType = builder.buildFeatureType();
        return featureType;

    }

    public SimpleFeature buildFeature(PointDTO dto, SimpleFeatureType schema) {
        SimpleFeatureBuilder builder = new SimpleFeatureBuilder(schema);
        Point p = GEOMBUILDER.point(dto.x.doubleValue(), dto.y.doubleValue());
        builder.set("the_geom", p);
        for (String[] att : dto.atributtes) {
            builder.set(att[0], att[1]);
        }
        return builder.buildFeature(dto.wkid.toString());
    }

    public class PointDTO {
        private String type;
        private Double x;
        private Double y;
        private Integer wkid;
        private List<String[]> atributtes = new ArrayList<String[]>();
        // Getters & Setters
    }
}
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.awt.geom.Point2D;
import java.util.List;

public class JsonPathApp {

    public static void main(String[] args) throws Exception {
        JsonMapper jsonMapper = JsonMapper.builder()
                .addMixIn(Point2D.Double.class, Point2DDoubleMixIn.class)
                .build();

        String json = "[[8.880321034663876,49.121984026160106],[8.746452886806255,49.11327654230291],[8.61786489671323,49.087497674922325]]";

        TypeReference<List<Point2D.Double>> type = new TypeReference<List<Point2D.Double>>() {};
        List<Point2D.Double> shapes = jsonMapper.readValue(json, type);
        System.out.println(shapes);
    }
}

@JsonFormat(shape = JsonFormat.Shape.ARRAY)
interface Point2DDoubleMixIn { }
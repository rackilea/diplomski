import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RoomInventoryResponse implements JsonSerializable {


    private Map<String, InventoryDetail> inventoryDetail = new HashMap<>();

    public Map<String, InventoryDetail> getInventoryDetail() {
        return inventoryDetail;
    }

    public void setInventoryDetail(Map<String, InventoryDetail> inventoryDetail) {
        this.inventoryDetail = inventoryDetail;
    }

    @Override
    public void serialize(JsonGenerator arg0, SerializerProvider arg1) throws IOException {
        arg0.writeObject(inventoryDetail);
    }

    @Override
    public void serializeWithType(JsonGenerator gen, SerializerProvider serializers, TypeSerializer typeSer) throws IOException {

    }
}
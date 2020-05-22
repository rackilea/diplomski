import com.google.datastore.v1.Entity;
import com.google.datastore.v1.Entity.Builder;
import com.google.datastore.v1.Value;
import com.google.protobuf.NullValue;

Value nullValue = Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build();
Entity.Builder builder = Entity.newBuilder();
builder.putProperties("propertyName", nullValue);
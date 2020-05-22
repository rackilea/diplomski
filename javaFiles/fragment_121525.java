import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "javaclass")
@JsonSubTypes({
    @Type(value = GreaterOrEqualQuery.class),
    @Type(value = EqualQuery.class)
    //and so on...
})
public abstract class BaseQuery {
    ...
}
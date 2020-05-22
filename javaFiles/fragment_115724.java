package be.smartask.service.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "_shards",
    "suggestions"
})
public class Suggestions {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("_shards")
    private be.smartask.service.model.Shards Shards;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("suggestions")
    private List<Suggestion> suggestions = new ArrayList<Suggestion>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    protected final static Object NOT_FOUND_VALUE = new Object();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The Shards
     */
    @JsonProperty("_shards")
    public be.smartask.service.model.Shards getShards() {
        return Shards;
    }

    /**
     * 
     * (Required)
     * 
     * @param Shards
     *     The _shards
     */
    @JsonProperty("_shards")
    public void setShards(be.smartask.service.model.Shards Shards) {
        this.Shards = Shards;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The suggestions
     */
    @JsonProperty("suggestions")
    public List<Suggestion> getSuggestions() {
        return suggestions;
    }

    /**
     * 
     * (Required)
     * 
     * @param suggestions
     *     The suggestions
     */
    @JsonProperty("suggestions")
    public void setSuggestions(List<Suggestion> suggestions) {
        this.suggestions = suggestions;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @SuppressWarnings({
        "unchecked"
    })
    protected boolean declaredProperty(String name, Object value) {
        if ("_shards".equals(name)) {
            if (value instanceof be.smartask.service.model.Shards) {
                setShards(((be.smartask.service.model.Shards) value));
            } else {
                throw new IllegalArgumentException(("property \"_shards\" is of type \"be.smartask.service.model.Shards\", but got "+ value.getClass().toString()));
            }
            return true;
        } else {
            if ("suggestions".equals(name)) {
                if (value instanceof List) {
                    setSuggestions(((List<Suggestion> ) value));
                } else {
                    throw new IllegalArgumentException(("property \"suggestions\" is of type \"java.util.List<be.smartask.service.model.Suggestion>\", but got "+ value.getClass().toString()));
                }
                return true;
            } else {
                return false;
            }
        }
    }

    @SuppressWarnings({
        "unchecked"
    })
    protected Object declaredPropertyOrNotFound(String name, Object notFoundValue) {
        if ("_shards".equals(name)) {
            return getShards();
        } else {
            if ("suggestions".equals(name)) {
                return getSuggestions();
            } else {
                return notFoundValue;
            }
        }
    }

    @SuppressWarnings({
        "unchecked"
    })
    public<T >T get(String name) {
        Object value = declaredPropertyOrNotFound(name, Suggestions.NOT_FOUND_VALUE);
        if (Suggestions.NOT_FOUND_VALUE!= value) {
            return ((T) value);
        } else {
            return ((T) getAdditionalProperties().get(name));
        }
    }

    @SuppressWarnings({
        "unchecked"
    })
    public void set(String name, Object value) {
        if (!declaredProperty(name, value)) {
            getAdditionalProperties().put(name, ((Object) value));
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(Shards).append(suggestions).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Suggestions) == false) {
            return false;
        }
        Suggestions rhs = ((Suggestions) other);
        return new EqualsBuilder().append(Shards, rhs.Shards).append(suggestions, rhs.suggestions).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
package example;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

        public class ObjectMapperProperties {

            private PropertyNamingStrategy propertyNamingStrategy;

            private ObjectMapperProperties(final PropertyNamingStrategy propertyNamingStrategy) {
                this.propertyNamingStrategy = propertyNamingStrategy;
            }

            public PropertyNamingStrategy getPropertyNamingStrategy() {
                return propertyNamingStrategy;
            }

            public static class ObjectMapperPropertiesBuilder {

                private PropertyNamingStrategy builderPropertyNamingStrategy;

                public ObjectMapperPropertiesBuilder() {

                }

                public ObjectMapperPropertiesBuilder setPropertyNamingStrategy(final PropertyNamingStrategy builderPropertyNamingStrategy) {
                    this.builderPropertyNamingStrategy = builderPropertyNamingStrategy; 
                    return this;
                }

                public ObjectMapperProperties build() {
                    return new ObjectMapperProperties(builderPropertyNamingStrategy);
                }

            }
    }
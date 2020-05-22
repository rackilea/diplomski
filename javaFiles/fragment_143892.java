import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


class Tranformation {


    public static void main(String[] args) {

        MyCar car = new MyCar();
        car.setId("id01");
        car.setName("Komodo");
        car.setMadeIn("Jakarta");

        CarDTO dto = toDto(CarDTO.class, car);

        System.out.println(dto);

    }

    public <E extends AbstractEntity, D extends GenericDTO> D toDto(Class<D> dtoClass, E entity) {
        if (null == entity) {
            throw new NullPointerException("Entity can not be null");
        }
        try {
            final D ret = dtoClass.newInstance();

            BeanInfo dtoBeanInfo = Introspector.getBeanInfo(dtoClass);

            final Map<String, PropertyDescriptor> mapping = Arrays.stream(dtoBeanInfo.getPropertyDescriptors())
                    .collect(Collectors.toMap(PropertyDescriptor::getName, Function.identity()));

            final BeanInfo entityBeanInfo = Introspector.getBeanInfo(entity.getClass());

            Arrays.stream(entityBeanInfo.getPropertyDescriptors()).forEach(src -> {
                if (!"class".equals(src.getName())) {
                    PropertyDescriptor dst = mapping.get(src.getName());
                    if (null != dst) {
                        try {
                            dst.getWriteMethod().invoke(ret, src.getReadMethod().invoke(entity, null));
                        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                            throw new IllegalStateException(e);
                        }
                    }
                }
            });

            return ret;
        } catch (InstantiationException | IntrospectionException | IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }

    public static class GenericDTO {
        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    public static class CarDTO extends GenericDTO {
        private String madeIn;

        public String getMadeIn() {
            return madeIn;
        }

        public void setMadeIn(String madeIn) {
            this.madeIn = madeIn;
        }

        @Override
        public String toString() {
            return String.format("CarDTO [id=%s, name=%s, madeIn=%s]", getId(), getName(), madeIn);
        }

    }

    public static class AbstractEntity implements Serializable {
        private static final long serialVersionUID = 70377433289079231L;
        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class MyCar extends AbstractEntity {
        private static final long serialVersionUID = 8702011501211036271L;
        private String madeIn;

        public String getMadeIn() {
            return madeIn;
        }

        public void setMadeIn(String madeIn) {
            this.madeIn = madeIn;
        }

    }

}
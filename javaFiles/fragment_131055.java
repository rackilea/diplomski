package org.example;

import java.util.*;
import javax.ws.rs.core.Application;
import org.eclipse.persistence.jaxb.rs.MOXyJsonProvider;

public class CustomerApplication  extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> set = new HashSet<Class<?>>(2);
        set.add(MOXyJsonProvider.class);
        set.add(CustomerService.class);
        return set;
    }
}
package de.scrum_master.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class BeanWithAutowire {
    //@Autowired
    private ScopedBean scopedBean;

    @Autowired
    public BeanWithAutowire(ScopedBean scopedBean) {
        this.scopedBean = scopedBean;
    }

    @Autowired
    public void setScopedBean(ScopedBean scopedBean) {
        this.scopedBean = scopedBean;
    }
}
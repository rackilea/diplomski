package mypackage;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Bean {

    public List<String> getList() {
        return Arrays.asList("foo", "bar");
    }

    public String getText() { 
        return "text";
    }

}
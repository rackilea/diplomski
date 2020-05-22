package struts2;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

@ParentPackage("json-default")
public class Test2 extends ActionSupport {

    private String string1 = "One";
    private String string2 = "Two";
    private String other = "Other";

    public String getString1() {
        return this.string1;
    }

    public String getString2() {
        return this.string2;
    }

    public String getOther() {
        return this.other;
    }

    @Action(value="/getJson1", results = {
        @Result(type = "json", params = {
            "includeProperties",
            "string1"
        })})
    public String action1() {
        return ActionSupport.SUCCESS;
    }

    @Action(value="/getJson2", results = {
        @Result(type = "json", params = {
            "includeProperties",
            "string2"
        })})
    public String action2() {
        return ActionSupport.SUCCESS;
    }

    @Action(value="/getJson3", results = {
        @Result(type = "json", params = {
            "excludeProperties",
            "string1, string2"
        })})
    public String action3() {
        return ActionSupport.SUCCESS;
    }
}
package com.john.rest.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonView;

import com.midtronics.esp.mobile.model.SystemObjectView;
import com.midtronics.esp.model.common.ICommonDAO;

@XmlRootElement
public class SystemObject implements Serializable
{
    private static final long serialVersionUID = 3989499187492868996L;

    @JsonProperty("id")
    @JsonView({SystemObjectView.ObjectList.class, SystemObjectView.ObjectDetail.class})
    protected String objectID = "";

    @JsonProperty("parentId")
    protected String parentID = "";

    @JsonProperty("name")
    @JsonView({SystemObjectView.ObjectList.class, SystemObjectView.ObjectDetail.class})
    protected String objectName = "";

    //getters...
    //setters...

}
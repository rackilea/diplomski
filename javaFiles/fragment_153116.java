//------------------model------------------------
//Generated code for model 
import java.io.Serializable;
public class {{table|capitalize}}_Model implements Serializable{
{%for columnName,columnTitle in columns%}
private String {{columnName|lower}};{%endfor%}

{% for columnName,columnTitle in columns %}
public void set{{columnName|capitalize}}(String {{columnName|lower}}){ 
  this.{{columnName|lower}}={{columnName|lower}};
}
public String get{{columnName|capitalize}}(){ 
  return this.{{columnName|lower}};
}
{% endfor %}
public {{table|capitalize}}_Model({% for columnName,columnTitle in columns %}String {{columnName|lower}}{% if not loop.last %},{% endif %}{% endfor %}){
        {% for columnName,columnTitle in columns %}
  this.{{columnName|lower}}={{columnName|lower}}; {% endfor %}  
    }
public String toString(){

return {% for columnName,columnTitle in columns %}"{{columnName|lower}}:" + this.{{columnName|lower}}{% if not loop.last %}+{% endif %}{% endfor %};

}

}
//------------------model------------------------
//-----------------getStrings--------------------
{% for columnName,columnTitle in columns %}
 String {{columnName}}=rs.getString("{{columnName}}");
{% endfor %}
//----------------------------------------------
//------------------jsp example-----------------
{% for columnName,columnTitle in columns %}
<s:label  cssStyle ="margin-top:5px;color:blue;" value="{{columnTitle[1]}} :" id="{{columnName}}_label"/>
<s:textfield label="{{columnTitle[1]}}" name="myBean.{{columnName}}" />
{% endfor %}
//------------------jsp example-----------------
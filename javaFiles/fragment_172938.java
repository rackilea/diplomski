import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;

@Entity
public class Address {

    @Any(metaColumn = @Column(name = "ITEM_TYPE"))
    @AnyMetaDef(idType = "long", metaType = "string",
            metaValues = {
                    @MetaValue(targetEntity = Student.class, value = "STUDENT"),
                    @MetaValue(targetEntity = Teacher.class, value = "TEACHER")
            })
    @JoinColumn(name="ITEM_ID")
    private Object item;

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String type;

    @Column
    private String street;

    @Column
    private int number;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Address{" +
                "person=" + item +
                ", id=" + id +
                ", type='" + type + '\'' +
                ", street='" + street + '\'' +
                ", number=" + number +
                '}';
    }
}
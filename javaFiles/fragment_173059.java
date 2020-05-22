import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PKClass implements Serializable {

    @Column(name = "NUM")
    private String num;

    @Column(name = "INIT")
    private String init;

    //gettter setter here

}
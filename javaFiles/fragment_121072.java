package forum10208143;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.persistence.oxm.annotations.XmlReadOnly;

/**
 * @author Martin Burchard
 * 
 */
@XmlRootElement(name = "user")
public class User {
    private String id;
    private String nickname;
    private String email;
    private String password;

    @XmlElement(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name = "nickname")
    public String getNickName() {
        return nickname;
    }

    public void setNickName(String nickname) {
        this.nickname = nickname;
    }

    @XmlElement(name = "email")
    public String getEMail() {
        return email;
    }

    public void setEMail(String email) {
        this.email = email;
    }

    @XmlElement(name = "password")
    @XmlReadOnly
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
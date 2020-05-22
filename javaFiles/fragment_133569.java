/**
 * ContenusPK.java
 * 
 * $Source$
 */
import java.io.Serializable;

public class ContenusPK implements Serializable
{
    public static final long serialVersionUID = 1L;

    private Long id;
    private String langue;

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((langue == null) ? 0 : langue.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ContenusPK other = (ContenusPK) obj;
        if (id == null)
        {
            if (other.id != null)
                return false;
        }
        else if (!id.equals(other.id))
            return false;
        if (langue == null)
        {
            if (other.langue != null)
                return false;
        }
        else if (!langue.equals(other.langue))
            return false;
        return true;
    }

    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }

    /**
     * @return the id
     */
    public Long getId()
    {
        return id;
    }

    /**
     * @return the langue
     */
    public String getLangue()
    {
        return langue;
    }

    /**
     * @param id the id to set
     */
    protected void setId(Long id)
    {
        this.id = id;
    }

    /**
     * @param langue the langue to set
     */
    protected void setLangue(String langue)
    {
        this.langue = langue;
    }

}
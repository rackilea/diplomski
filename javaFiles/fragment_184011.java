@XmlAttribute(name="prototype")
@XmlIDREF
@Override
public <T> void setPrototype(T prototype)
{
    m_data = ((Item)prototype).getData();
}
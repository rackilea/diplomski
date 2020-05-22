@Override
public String toString() {

    return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
            .append("Name", value)
            .append("Horizontal", xPos)
            .append("Vertical", yPos)

            .toString();
}
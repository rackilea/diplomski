@Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("*headline=");
    sb.append(headline);
    sb.append(";");
    sb.append("speed=");
    sb.append(speed);
    sb.append(";");
    sb.append("direction=");
    sb.append(direction);
    sb.append(";");
    sb.append("date=");
    sb.append(date);
    return sb.toString();
}
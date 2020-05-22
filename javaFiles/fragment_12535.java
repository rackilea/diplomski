public class Test2 {
private String month;
private String type;
private String name;


public Test2(String month, String type, String name) {
    setMonth(month);
    setType(type);
    setName(name);
}

/**
 * @return the month
 */
public String getMonth() {
    return month;
}

/**
 * @param month the month to set
 */
public void setMonth(String month) {
    this.month = month;
}

/**
 * @return the Type
 */
public String getType() {
    return type;
}

/**
 * @param Type the Type to set
 */
public void setType(String type) {
    this.type = type;
}

/**
 * @return the name
 */
public String getName() {
    return name;
}

/**
 * @param name the name to set
 */
public void setName(String name) {
    this.name = name;
}

}
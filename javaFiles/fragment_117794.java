private String style;

@PostConstruct
public void init() {
    style = "background: pink;"; // Or something dynamic.
}

public String getStyle() {
    return style;
}
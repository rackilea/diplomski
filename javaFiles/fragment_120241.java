static class Config {
    @RegExp("^(one|two)$")
    public String number;

    public Boolean check;

    @Required @Range(min=1, max=6)
    public Integer totalnum;
}
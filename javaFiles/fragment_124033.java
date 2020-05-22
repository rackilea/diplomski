class Model{

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="MM-dd-yyyy",timezone="CET")
    private Date date;

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }
}

public static void main(String[] args) throws Exception{
        Model model = new Model();
        model.setDate(new Date());

        System.out.println(new ObjectMapper().writeValueAsString(model));
    }
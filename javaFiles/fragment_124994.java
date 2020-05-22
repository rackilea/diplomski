class MyModel {
    String area;
    String subarea;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate datestamp;
    String leadname;
    String viceleadname;
    @Override
    public String toString() {
        return "MyModel [area=" + area + ", subarea=" + subarea + ", datestamp=" + datestamp + ", leadname=" + leadname
                + ", viceneadname=" + viceleadname + "]";
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public String getSubarea() {
        return subarea;
    }
    public void setSubarea(String subarea) {
        this.subarea = subarea;
    }
    public LocalDate getDatestamp() {
        return datestamp;
    }
    public void setDatestamp(LocalDate datestamp) {
        this.datestamp = datestamp;
    }
    public String getLeadname() {
        return leadname;
    }
    public void setLeadname(String leadname) {
        this.leadname = leadname;
    }
    public String getViceneadname() {
        return viceleadname;
    }
    public void setViceneadname(String viceleadname) {
        this.viceleadname = viceleadname;
    }
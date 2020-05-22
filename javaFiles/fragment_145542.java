Date temp = null;
try {
    temp = dateFormat.parse(timestamp);
} catch (ParseException ex) {
    Logger.getLogger(Visit.class.getName()).log(Level.SEVERE, null, ex);
}

this.timestamp = (temp == null ? <some default Date value> : temp);
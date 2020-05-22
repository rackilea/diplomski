@Entity
@Table(name="wafat")
class Wafat implements Serializable{

private String kode_wafat;
private int no_dana;
private Date tgl_wafat;
private int usia_wafat;
private Date tgl_makam;
private String tempat_makam;

@Column(name="kode_wafat", unique=true, nullable=false)
public String getKode_wafat() {
    return kode_wafat;
}
public void setKode_wafat(String kode_wafat) {
    this.kode_wafat = kode_wafat;
}
@Id
@JoinColumn(name="no_dana")
public int getNo_dana() {
    return no_dana;
}
public void setNo_dana(int no_dana) {
    this.no_dana = no_dana;
}
@Temporal(TemporalType.TIMESTAMP)
@Column(name="tgl_wafat")
public Date getTgl_wafat() {
    return tgl_wafat;
}
public void setTgl_wafat(Date tgl_wafat) {
    this.tgl_wafat = tgl_wafat;
}
@Column(name="usia_wafat")
public int getUsia_wafat() {
    return usia_wafat;
}
public void setUsia_wafat(int usia_wafat) {
    this.usia_wafat = usia_wafat;
}
@Temporal(TemporalType.TIMESTAMP)
@Column(name="tgl_makam")
public Date getTgl_makam() {
    return tgl_makam;
}
public void setTgl_makam(Date tgl_makam) {
    this.tgl_makam = tgl_makam;
}
@Column(name="tempat_makam")
public String getTempat_makam() {
    return tempat_makam;
}
public void setTempat_makam(String tempat_makam) {
    this.tempat_makam = tempat_makam;
}

private UserAdmin useradmin;

@OneToOne
@MapsId
@JoinColumn(name="no_dana")
public UserAdmin getUseradmin() {
    return useradmin;
}
public void setUseradmin(UserAdmin useradmin) {
    this.useradmin = useradmin;
}

}
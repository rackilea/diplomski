@Entity
@Table(name="user")
class UserAdmin implements Serializable {

private int no_dana;
private String npp;
private String password;
private String nama_depan;
private String nama_tengah;
private String nama_belakang;
private String agama;
private String jenis_kelamin;
private Date tgl_lahir; 
private String alamat;
private String rt;
private String rw;
private String kelurahan;
private String kecamatan;
private String kota;
private String kode_pos;
private String propinsi;
private String no_telepon;
private String no_handphone_1;
private String no_handphone_2;
private String display_name;
private Date tgl_gabung;
private Date last_login;
private Integer enabled;
private String status;
private String unit_terakhir;
private String jabatan_terakhir;
private String pangkat_terakhir;
private String authority;

@Id
@GeneratedValue
@Column(name="no_dana", unique=true, nullable=false)
public int getNo_dana() {
    return no_dana;
}
public void setNo_dana(int no_dana) {
    this.no_dana = no_dana;
}
@Column(name="npp")
public String getNpp() {
    return npp;
}
public void setNpp(String npp) {
    this.npp = npp;
}
@Column(name="password")
public String getPassword() {
    return password;
}
public void setPassword(String password) {
    this.password = password;
}
@Column(name="nama_depan")
public String getNama_depan() {
    return nama_depan;
}
public void setNama_depan(String nama_depan) {
    this.nama_depan = nama_depan;
}
@Column(name="nama_tengah")
public String getNama_tengah() {
    return nama_tengah;
}
public void setNama_tengah(String nama_tengah) {
    this.nama_tengah = nama_tengah;
}
@Column(name="nama_belakang")
public String getNama_belakang() {
    return nama_belakang;
}
public void setNama_belakang(String nama_belakang) {
    this.nama_belakang = nama_belakang;
}
@Column(name="agama")
public String getAgama() {
    return agama;
}
public void setAgama(String agama) {
    this.agama = agama;
}
@Column(name="jenis_kelamin")
public String getJenis_kelamin() {
    return jenis_kelamin;
}
public void setJenis_kelamin(String jenis_kelamin) {
    this.jenis_kelamin = jenis_kelamin;
}
@Temporal(TemporalType.DATE)
@Column(name = "tgl_lahir")
public Date getTgl_lahir() {
    return tgl_lahir;
}
public void setTgl_lahir(Date tgl_lahir) {
    this.tgl_lahir = tgl_lahir;
}

@Column(name="alamat")
public String getAlamat() {
    return alamat;
}
public void setAlamat(String alamat) {
    this.alamat = alamat;
}

@Column(name="rt")
public String getRt() {
    return rt;
}
public void setRt(String rt) {
    this.rt = rt;
}
@Column(name="rw")
public String getRw() {
    return rw;
}
public void setRw(String rw) {
    this.rw = rw;
}

@Column(name="kelurahan")
public String getKelurahan() {
    return kelurahan;
}
public void setKelurahan(String kelurahan) {
    this.kelurahan = kelurahan;
}

@Column(name="kecamatan")
public String getKecamatan() {
    return kecamatan;
}
public void setKecamatan(String kecamatan) {
    this.kecamatan = kecamatan;
}

@Column(name="kota")
public String getKota() {
    return kota;
}
public void setKota(String kota) {
    this.kota = kota;
}

@Column(name="kode_pos")
public String getKode_pos() {
    return kode_pos;
}
public void setKode_pos(String kode_pos) {
    this.kode_pos = kode_pos;
}

@Column(name="propinsi")
public String getPropinsi() {
    return propinsi;
}
public void setPropinsi(String propinsi) {
    this.propinsi = propinsi;
}

@Column(name="no_telepon")
public String getNo_telepon() {
    return no_telepon;
}
public void setNo_telepon(String no_telepon) {
    this.no_telepon = no_telepon;
}
@Column(name="no_handphone_1")
public String getNo_handphone_1() {
    return no_handphone_1;
}
public void setNo_handphone_1(String no_handphone_1) {
    this.no_handphone_1 = no_handphone_1;
}

@Column(name="no_handphone_2")
public String getNo_handphone_2() {
    return no_handphone_2;
}
public void setNo_handphone_2(String no_handphone_2) {
    this.no_handphone_2 = no_handphone_2;
}

@Column(name="display_name")
public String getDisplay_name() {
    return display_name;
}
public void setDisplay_name(String display_name) {
    this.display_name = display_name;
}
@Temporal(TemporalType.TIMESTAMP)
@Column(name = "tgl_gabung")
public Date getTgl_gabung() {
    return tgl_gabung;
}
public void setTgl_gabung(Date tgl_gabung) {
    this.tgl_gabung = tgl_gabung;
}
@Temporal(TemporalType.TIMESTAMP)
@Column(name = "last_login")
public Date getLast_login() {
    return last_login;
}
public void setLast_login(Date last_login) {
    this.last_login = last_login;
}
@Column(name="enabled")
public Integer getEnabled() {
    return enabled;
}
public void setEnabled(Integer enabled) {
    this.enabled = enabled;
}
@Column(name="status")
public String getStatus() {
    return status;
}
public void setStatus(String status) {
    this.status = status;
}
@Column(name="unit_terakhir")
public String getUnit_terakhir() {
    return unit_terakhir;
}
public void setUnit_terakhir(String unit_terakhir) {
    this.unit_terakhir = unit_terakhir;
}
@Column(name="jabatan_terakhir")
public String getJabatan_terakhir() {
    return jabatan_terakhir;
}
public void setJabatan_terakhir(String jabatan_terakhir) {
    this.jabatan_terakhir = jabatan_terakhir;
}
@Column(name="pangkat_terakhir")
public String getPangkat_terakhir() {
    return pangkat_terakhir;
}
public void setPangkat_terakhir(String pangkat_terakhir) {
    this.pangkat_terakhir = pangkat_terakhir;
}
@Column(name="authority")
public String getAuthority() {
    return authority;
}
public void setAuthority(String authority) {
    this.authority = authority;
}

private Wafat wafat;

@OneToOne(mappedBy="useradmin", cascade=CascadeType.ALL)
@PrimaryKeyJoinColumn
public Wafat getWafat(){
    return wafat;
}

public void setWafat(Wafat wafat){
    this.wafat = wafat;
}
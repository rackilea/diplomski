@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

@NotEmpty
private String fullname;

@NotNull
private String identificacion;

@NotNull
@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date nacimiento;


@Column(unique=true)
private String nombre;


private String web;


private String facebook;


private String referencia;


private String instagram;


private String twitter;


private String foto;

@NotNull
private String clave;


private int codigo_postal;

@NotNull
@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date fecha_registro;

@NotNull
private String telefono;

@NotNull
private String direccion;

@NotNull
private boolean estado;


private String detalle;


private String pasaporte;

@NotNull
private String celular;


private String whatsapp;

@NotNull
private String correo;


private long codigo_usuario_registro;


private long codigo_tipo_registro_clasificacion;


private long codigo_tipo_registro_ubicacion;


private long codigo_tipo_registro_categoria;


private long codigo_tipo_registro_empresa;

@NotNull
private String sexo;

/*-------------------------------------------------------------*/

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public String getIdentificacion() {
    return identificacion;
}

public void setIdentificacion(String identificacion) {
    this.identificacion = identificacion;
}

public Date getNacimiento() {
    return nacimiento;
}

public void setNacimiento(Date nacimiento) {
    this.nacimiento = nacimiento;
}

public String getFullName() {
    return fullname;
}

public void setFullName(String fullname) {
    this.fullname = fullname;
}

public String getWeb() {
    return web;
}

public void setWeb(String web) {
    this.web = web;
}

public String getFacebook() {
    return facebook;
}

public void setFacebook(String facebook) {
    this.facebook = facebook;
}

public String getReferencia() {
    return referencia;
}

public void setReferencia(String referencia) {
    this.referencia = referencia;
}

public String getInstagram() {
    return instagram;
}

public void setInstagram(String instagram) {
    this.instagram = instagram;
}

public String getTwitter() {
    return twitter;
}

public void setTwitter(String twitter) {
    this.twitter = twitter;
}

public String getFoto() {
    return foto;
}

public void setFoto(String foto) {
    this.foto = foto;
}

public String getClave() {
    return clave;
}

public void setClave(String clave) {
    this.clave = clave;
}

public int getCodigo_postal() {
    return codigo_postal;
}

public void setCodigo_postal(int codigo_postal) {
    this.codigo_postal = codigo_postal;
}

public Date getFecha_registro() {
    return fecha_registro;
}

public void setFecha_registro(Date fecha_registro) {
    this.fecha_registro = fecha_registro;
}

public String getTelefono() {
    return telefono;
}

public void setTelefono(String telefono) {
    this.telefono = telefono;
}

public String getDireccion() {
    return direccion;
}

public void setDireccion(String direccion) {
    this.direccion = direccion;
}

public boolean isEstado() {
    return estado;
}

public void setEstado(boolean estado) {
    this.estado = estado;
}

public String getDetalle() {
    return detalle;
}

public void setDetalle(String detalle) {
    this.detalle = detalle;
}

public String getPasaporte() {
    return pasaporte;
}

public void setPasaporte(String pasaporte) {
    this.pasaporte = pasaporte;
}

public String getCelular() {
    return celular;
}

public void setCelular(String celular) {
    this.celular = celular;
}

public String getWhatsapp() {
    return whatsapp;
}

public void setWhatsapp(String whatsapp) {
    this.whatsapp = whatsapp;
}

public String getCorreo() {
    return correo;
}

public void setCorreo(String correo) {
    this.correo = correo;
}

public long getCodigo_usuario_registro() {
    return codigo_usuario_registro;
}

public void setCodigo_usuario_registro(long codigo_usuario_registro) {
    this.codigo_usuario_registro = codigo_usuario_registro;
}

public long getCodigo_tipo_registro_clasificacion() {
    return codigo_tipo_registro_clasificacion;
}

public void setCodigo_tipo_registro_clasificacion(long codigo_tipo_registro_clasificacion) {
    this.codigo_tipo_registro_clasificacion = codigo_tipo_registro_clasificacion;
}

public long getCodigo_tipo_registro_ubicacion() {
    return codigo_tipo_registro_ubicacion;
}

public void setCodigo_tipo_registro_ubicacion(long codigo_tipo_registro_ubicacion) {
    this.codigo_tipo_registro_ubicacion = codigo_tipo_registro_ubicacion;
}

public long getCodigo_tipo_registro_categoria() {
    return codigo_tipo_registro_categoria;
}

public void setCodigo_tipo_registro_categoria(long codigo_tipo_registro_categoria) {
    this.codigo_tipo_registro_categoria = codigo_tipo_registro_categoria;
}

public long getCodigo_tipo_registro_empresa() {
    return codigo_tipo_registro_empresa;
}

public void setCodigo_tipo_registro_empresa(long codigo_tipo_registro_empresa) {
    this.codigo_tipo_registro_empresa = codigo_tipo_registro_empresa;
}

public String getSexo() {
    return sexo;
}

public void setSexo(String sexo) {
    this.sexo = sexo;
}





}
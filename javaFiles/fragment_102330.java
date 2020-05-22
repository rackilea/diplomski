**Cotizacion.java**

@Entity
@Table(name = "cotizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cotizacion.findAll", query = "SELECT c FROM Cotizacion c"),
    @NamedQuery(name = "Cotizacion.findByCotizacionId", query = "SELECT c FROM Cotizacion c WHERE c.cotizacionId = :cotizacionId")})
public class Cotizacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cotizacion_id")
    private Integer cotizacionId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cotizacion")
    private DetalleCotizacion detalleCotizacion;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne(optional = false)
    private Persona idPersona;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false)
    private Empleado idEmpleado;

    //Getters And Settes
}

**DetalleCotizacion.java**

@Entity
@Table(name = "detalle_cotizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleCotizacion.findAll", query = "SELECT d FROM DetalleCotizacion d"),
    @NamedQuery(name = "DetalleCotizacion.findByCotizacionId", query = "SELECT d FROM DetalleCotizacion d WHERE d.cotizacionId = :cotizacionId")})
public class DetalleCotizacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cotizacion_id")
    private Integer cotizacionId;
    @JoinColumn(name = "id_vidrio", referencedColumnName = "id_vidrio")
    @ManyToOne(optional = false)
    private Vidrio idVidrio;
    @JoinColumn(name = "cotizacion_id", referencedColumnName = "cotizacion_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Cotizacion cotizacion;

    //Getters And Setters
}

**DetalleFactura.java**

@Entity
@Table(name = "detalle_factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleFactura.findAll", query = "SELECT d FROM DetalleFactura d"),
    @NamedQuery(name = "DetalleFactura.findByFacturaId", query = "SELECT d FROM DetalleFactura d WHERE d.facturaId = :facturaId")})
public class DetalleFactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "factura_id")
    private Integer facturaId;
    @JoinColumn(name = "id_vidrio", referencedColumnName = "id_vidrio")
    @ManyToOne(optional = false)
    private Vidrio idVidrio;
    @JoinColumn(name = "factura_id", referencedColumnName = "factura_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Factura factura;

    //Getters And Setters
}

**Empleado.java**

@Entity
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByIdEmpleado", query = "SELECT e FROM Empleado e WHERE e.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "Empleado.findByGerente", query = "SELECT e FROM Empleado e WHERE e.gerente = :gerente"),
    @NamedQuery(name = "Empleado.findByContrasena", query = "SELECT e FROM Empleado e WHERE e.contrasena = :contrasena")})
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_empleado")
    private String idEmpleado;
    @Basic(optional = false)
    @Column(name = "gerente")
    private boolean gerente;
    @Basic(optional = false)
    @Column(name = "contrasena")
    private String contrasena;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleado")
    private Set<Cotizacion> cotizacionSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleadoCorte")
    private Set<Factura> facturaSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleado")
    private Set<Factura> facturaSet1;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne(optional = false)
    private Persona idPersona;

    //Getters And Setters
}

**Factura.java**

@Entity
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findByFacturaId", query = "SELECT f FROM Factura f WHERE f.facturaId = :facturaId"),
    @NamedQuery(name = "Factura.findByFecha", query = "SELECT f FROM Factura f WHERE f.fecha = :fecha")})
public class Factura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "factura_id")
    private Integer facturaId;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne(optional = false)
    private Persona idPersona;
    @JoinColumn(name = "id_empleado_corte", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false)
    private Empleado idEmpleadoCorte;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false)
    private Empleado idEmpleado;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "factura")
    private DetalleFactura detalleFactura;

    //Getters And Setters
}

**Persona.java**

@Entity
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByIdPersona", query = "SELECT p FROM Persona p WHERE p.idPersona = :idPersona"),
    @NamedQuery(name = "Persona.findByNombre", query = "SELECT p FROM Persona p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Persona.findByApellido", query = "SELECT p FROM Persona p WHERE p.apellido = :apellido"),
    @NamedQuery(name = "Persona.findByDireccion", query = "SELECT p FROM Persona p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Persona.findByCiudad", query = "SELECT p FROM Persona p WHERE p.ciudad = :ciudad"),
    @NamedQuery(name = "Persona.findByTelefono", query = "SELECT p FROM Persona p WHERE p.telefono = :telefono")})
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_persona")
    private String idPersona;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private Set<Cotizacion> cotizacionSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private Set<Factura> facturaSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private Set<Empleado> empleadoSet;

    //Getters And Setters
}

Vidrio.java

@Entity
@Table(name = "vidrio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vidrio.findAll", query = "SELECT v FROM Vidrio v"),
    @NamedQuery(name = "Vidrio.findByIdVidrio", query = "SELECT v FROM Vidrio v WHERE v.idVidrio = :idVidrio"),
    @NamedQuery(name = "Vidrio.findByGrosor", query = "SELECT v FROM Vidrio v WHERE v.grosor = :grosor"),
    @NamedQuery(name = "Vidrio.findByLargo", query = "SELECT v FROM Vidrio v WHERE v.largo = :largo"),
    @NamedQuery(name = "Vidrio.findByAncho", query = "SELECT v FROM Vidrio v WHERE v.ancho = :ancho"),
    @NamedQuery(name = "Vidrio.findByPrecio", query = "SELECT v FROM Vidrio v WHERE v.precio = :precio"),
    @NamedQuery(name = "Vidrio.findByDescripcion", query = "SELECT v FROM Vidrio v WHERE v.descripcion = :descripcion")})
public class Vidrio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vidrio")
    private Integer idVidrio;
    @Basic(optional = false)
    @Column(name = "grosor")
    private double grosor;
    @Basic(optional = false)
    @Column(name = "largo")
    private double largo;
    @Basic(optional = false)
    @Column(name = "ancho")
    private double ancho;
    @Basic(optional = false)
    @Column(name = "precio")
    private double precio;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVidrio")
    private Set<DetalleCotizacion> detalleCotizacionSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVidrio")
    private Set<DetalleFactura> detalleFacturaSet;

    //Getters And Setters
}
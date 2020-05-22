package co.com.hermesWeb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="FactorUnidadMedida")
@IdClass(FactorUnidadMedidaPK.class)
public class FactorUnidadMedida implements Serializable {
    private static final long serialVersionUID = -4123771692139896513L;

    @Id
    private int idEmpresa = 0;
    @Id
    private String codUnidadOrigen = "";
    @Id
    private String codUnidadDestino = "";

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumns({
        @JoinColumn(name="idEmpresa", referencedColumnName="idEmpresa", insertable=false, updatable=false),
        @JoinColumn(name="codUnidadOrigen", referencedColumnName="codigo", insertable=false, updatable=false)
    })
    private UnidadMedida unidadMedidaOrigen = null; 

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumns({
        @JoinColumn(name="idEmpresa", referencedColumnName="idEmpresa", insertable=false, updatable=false),
        @JoinColumn(name="codUnidadDestino", referencedColumnName="codigo", insertable=false, updatable=false)
    })
    private UnidadMedida unidadMedidaDestino = null;
    private BigDecimal factor = BigDecimal.ZERO;
    private String estado = "";
    private String usuario = "";
    private Date fecha = null;

    public int getIdEmpresa() {
        return idEmpresa;
    }
    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    public UnidadMedida getUnidadMedidaOrigen() {
        return unidadMedidaOrigen;
    }
    public UnidadMedida getUnidadMedidaDestino() {
        return unidadMedidaDestino;
    }
    public BigDecimal getFactor() {
        return factor;
    }
    public void setFactor(BigDecimal factor) {
        this.factor = factor;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getCodUnidadOrigen() {
        return codUnidadOrigen;
    }
    public void setCodUnidadOrigen(String codUnidadOrigen) {
        this.codUnidadOrigen = codUnidadOrigen;
    }
    public String getCodUnidadDestino() {
        return codUnidadDestino;
    }
    public void setCodUnidadDestino(String codUnidadDestino) {
        this.codUnidadDestino = codUnidadDestino;
    }

}
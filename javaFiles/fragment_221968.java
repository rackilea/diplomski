//bi-directional many-to-one association to TipoVehiculo
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tipo_vehiculo_idTipoVehiculo", nullable=false, referencedColumnName="idTipoVehiculo")
    public TipoVehiculo getTipoVehiculo() {
        return this.tipoVehiculo;
    }
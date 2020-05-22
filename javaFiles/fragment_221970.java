//bi-directional many-to-one association to TipoVehiculo
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tipo_vehiculo_idtipovehiculo", nullable=false)
    public TipoVehiculo getTipoVehiculo() {
        return this.tipoVehiculo;
    }
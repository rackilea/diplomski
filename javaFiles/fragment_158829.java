public String getInfoDerivada(int pos){
    if(pos < 0 || pos >= cont){
        return null;
    }
    if(vehiculos[pos] instanceof Coche){
        return ((Coche)vehiculos[pos]).getColor();
    } else if(vehiculos[pos] instanceof Moto){
        return String.valueOf(((Moto)vehiculos[pos]).getPotencia());
    } else if(vehiculos[pos] instanceof Camion){
        return String.valueOf(((Camion)vehiculos[pos]).getTonelaje());
    }
    throw new IllegalStateException(
        String.format("Unknown type: %s", vehiculos[pos].getClass().getName())
    );
}
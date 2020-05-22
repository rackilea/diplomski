finally {//cerrando muestras
            if(muestras!=null){
                muestras.closeStreams();
            }

            if(salida!=null){
                salida.closeStreams();
            }

}
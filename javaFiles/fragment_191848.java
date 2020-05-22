private Credito(String numero, String titular, LocalDate fechacaducidad, int marcainternacional,
        String nombreentidad, int ccv) {
    mNumero = numero;
    mTitular = titular;
    mFechaDeCaducidad = fechacaducidad;
    mMovimientos = new Vector<Movimiento>();
    mMarcaInternacional = marcainternacional;
    setmNombreEntidad(nombreentidad); // *** See warning
    setmCCV(ccv);                     // *** See warning
}

public Credito(String numero, String titular, LocalDate fechacaducidad, double credito, int marcainternacional,
        String nombreentidad, int ccv) {
    this(numero, titular, fechacaducidad, marcainternacional, nombreentidad, ccv);
    mCredito = credito;
}

public Credito(String numero, String titular, LocalDate fechacaducidad, int tipo, int marcainternacional,
        String nombreentidad, int ccv) {
    this(numero, titular, fechacaducidad, marcainternacional, nombreentidad, ccv);
    mTipo = tipo;
    mCredito = calcularCredito(mTipo);
}